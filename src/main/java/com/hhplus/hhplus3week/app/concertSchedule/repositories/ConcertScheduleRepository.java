package com.hhplus.hhplus3week.app.concertSchedule.repositories;

import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertScheduleRepository extends JpaRepository<ConcertSchedule, Long> {
}
