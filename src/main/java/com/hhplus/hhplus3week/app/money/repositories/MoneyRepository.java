package com.hhplus.hhplus3week.app.money.repositories;

import com.hhplus.hhplus3week.app.money.models.Money;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyRepository extends JpaRepository<Money, Long> {
    Money findByUserId(Long userId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT m FROM Money m WHERE m.id = :id")
    Money findByIdWithLock(Long id);
}
