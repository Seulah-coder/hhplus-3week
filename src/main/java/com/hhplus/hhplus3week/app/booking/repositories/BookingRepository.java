package com.hhplus.hhplus3week.app.booking.repositories;

import com.hhplus.hhplus3week.app.booking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByConcertScheduleId(Long concertScheduleId);
}
