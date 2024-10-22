package com.hhplus.hhplus3week.app.concertSchedule.repositories;

import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConcertScheduleRepository extends JpaRepository<ConcertSchedule, Long> {

    @Query("SELECT c FROM ConcertSchedule c LEFT JOIN FETCH c.seatList s WHERE c.id = :concertScheduleId AND s.seatStatus = 'AVAILABLE'")
    ConcertSchedule findByIdWithAvailableSeats(@Param("id") Long concertScheduleId);

    @Query("SELECT c FROM ConcertSchedule c WHERE c.concert.id = :concertId AND c.ticketOpenDate > :currentDate")
    List<ConcertSchedule> findAllByIdConcertIdAfterDate(Long concertId, LocalDateTime currentDate);
}
