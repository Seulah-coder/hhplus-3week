package com.hhplus.hhplus3week.app.waitingQueue.schedulers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.hhplus.hhplus3week.app.waitingQueue.repositories.WaitingQueueRepository;
import com.hhplus.hhplus3week.app.waitingQueue.services.WaitingQueueService;
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
    private final WaitingQueueService waitingQueueService;

    public WaitingQueueScheduler(EntityManager entityManager, WaitingQueueRepository waitingQueueRepository, WaitingQueueService waitingQueueService) {
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        this.entityManager = entityManager;
        this.waitingQueueRepository = waitingQueueRepository;
        this.waitingQueueService = waitingQueueService;
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
            waitingQueueService.deleteWaitingQueue(now);
        } catch (Exception e) {
            log.error("에러 발생 ", e);
        }
    }

    @Transactional
    protected void updateWaitingStatus() {
        try {
            List<Long> concertIds = waitingQueueService.findDistinctConcertIds();

            for (Long concertId : concertIds) {
                waitingQueueService.updateWaitingQueueRank(concertId, LocalDateTime.now());
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