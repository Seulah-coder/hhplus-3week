package com.hhplus.hhplus3week.app.waitingQueue.schedulers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.hhplus.hhplus3week.app.waitingQueue.repositories.WaitingQueueRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WaitingQueueScheduler {
    private final ScheduledExecutorService scheduler;
    private final EntityManager entityManager;
    private final WaitingQueueRepository waitingQueueRepository;

    public WaitingQueueScheduler(EntityManager entityManager, WaitingQueueRepository waitingQueueRepository) {
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        this.entityManager = entityManager;
        this.waitingQueueRepository = waitingQueueRepository;
    }

    public void startScheduler() {
        // 만료된 항목 제거 스케줄러
        scheduler.scheduleAtFixedRate(
                this::removeExpiredEntries,
                0,
                1,
                TimeUnit.MINUTES
        );

        // 대기 상태 업데이트 스케줄러
        scheduler.scheduleAtFixedRate(
                this::updateWaitingStatus,
                0,
                1,
                TimeUnit.MINUTES
        );
    }

    @Transactional
    protected void removeExpiredEntries() {
        try {
            LocalDateTime now = LocalDateTime.now();
            String jpql = "DELETE FROM WaitingQueue w WHERE w.expireTime < :now";
            int deletedCount = entityManager.createQuery(jpql)
                    .setParameter("now", now)
                    .executeUpdate();

            log.info("{} 개 삭제됨", deletedCount);
        } catch (Exception e) {
            log.error("에러 발생 ", e);
        }
    }

    @Transactional
    protected void updateWaitingStatus() {
        try {
            // 1. 모든 고유한 콘서트 ID 조회
            List<Long> concertIds = waitingQueueRepository.findDistinctConcertIds();

            for (Long concertId : concertIds) {
                // 2. 각 콘서트별 대기열 수 확인
                long queueCount = waitingQueueRepository.countByConcertId(concertId);

                if (queueCount < 50) {
                    // 3. 상위 3명의 대기 상태 업데이트
                    String updateQuery = """
                        UPDATE WaitingQueue w
                        SET w.waitingStatus = 'pass', w.updateTime = :now
                        WHERE w.concertId = :concertId
                        AND w.id IN (
                            SELECT sub.id
                            FROM WaitingQueue sub
                            WHERE sub.concertId = :concertId
                            ORDER BY sub.waitingIndex ASC
                            LIMIT 3
                        )
                    """;

                    int updatedCount = entityManager.createQuery(updateQuery)
                            .setParameter("now", LocalDateTime.now())
                            .setParameter("concertId", concertId)
                            .executeUpdate();

                    log.info("{}개 상태 업데이트 됨", updatedCount);
                }
            }
        } catch (Exception e) {
            log.error("에러 발생 ", e);
        }
    }

    public void stopScheduler() {
        try {
            scheduler.shutdown();
            if (!scheduler.awaitTermination(1, TimeUnit.MINUTES)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}