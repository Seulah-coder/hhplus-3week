package com.hhplus.hhplus3week.app.concert.repositories;

import com.hhplus.hhplus3week.app.concert.models.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
}
