package com.hhplus.hhplus3week.app.waitingQueue.repositories;

import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaitingQueueRepository extends JpaRepository<WaitingQueue, Long> {
    List<WaitingQueue> findAllByConcertScheduleId(Long concertScheduleId);
}
