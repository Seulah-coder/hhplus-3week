package com.hhplus.hhplus3week.app.concertSchedule.repositories;

import com.hhplus.hhplus3week.app.concert.models.Concert;
import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertScheduleRepository extends JpaRepository<ConcertSchedule, Long> {

    List<ConcertSchedule> findAllById(Long concertId);

    @Query("SELECT c FROM ConcertSchedule c LEFT JOIN FETCH c.seatList WHERE c.id = :concertId")
    ConcertSchedule findByIdWithSeats(@Param("id") Long concertId);
}
