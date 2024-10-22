package com.hhplus.hhplus3week.app.waitingQueue.repositories;

import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaitingQueueRepository extends JpaRepository<WaitingQueue, Long> {
    List<WaitingQueue> findAllByConcertId(Long concertId);

    @Query("SELECT MAX(w.waitingIndex) FROM WaitingQueue w WHERE w.concertId = :concertId")
    int findMaxWaitingIndex(Long concertId);

    WaitingQueue findByUserId(Long userId);
}
