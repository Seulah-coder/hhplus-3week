package com.hhplus.hhplus3week.app.concert.repositories;

import com.hhplus.hhplus3week.app.concert.models.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

    @Query("SELECT c FROM Concert c LEFT JOIN FETCH c.concertSchedules WHERE c.id = :id")
    Concert findByIdWithSchedules(@Param("id") Long id);
}
