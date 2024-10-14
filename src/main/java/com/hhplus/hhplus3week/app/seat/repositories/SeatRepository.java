package com.hhplus.hhplus3week.app.seat.repositories;

import com.hhplus.hhplus3week.app.seat.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
