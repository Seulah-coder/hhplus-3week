package com.hhplus.hhplus3week.app.waitingQueue.repositories;

import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WaitingQueueRepository extends JpaRepository<WaitingQueue, Long> {
    List<WaitingQueue> findAllByConcertId(Long concertId);

    @Query("SELECT MAX(w.waitingIndex) FROM WaitingQueue w WHERE w.concertId = :concertId")
    int findMaxWaitingIndex(Long concertId);

    WaitingQueue findByUserId(Long userId);

    @Modifying
    @Query("DELETE FROM WaitingQueue w WHERE w.expireTime < :time")
    int deleteExpiredWaitingQueue(LocalDateTime time);

    @Query("SELECT DISTINCT w.concertId FROM WaitingQueue w")
    List<Long> findDistinctConcertIds();

    int countByConcertId(Long concertId);

    @Query("UPDATE WaitingQueue w SET w.waitingStatus = 'PASS', w.updateTime = :now WHERE w.concertId = :concertId AND w.id IN " +
            "(SELECT sub.id FROM WaitingQueue sub WHERE sub.concertId = :concertId ORDER BY sub.waitingIndex ASC LIMIT 3)")
    void updateWaitingQueueRank(Long concertId, LocalDateTime time);
}
