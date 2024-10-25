package com.hhplus.hhplus3week.app.money.repositories;

import com.hhplus.hhplus3week.app.money.models.MoneyHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyHistoryRepository extends JpaRepository<MoneyHistory, Long> {
}
