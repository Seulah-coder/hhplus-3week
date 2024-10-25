package com.hhplus.hhplus3week.app.payment.repositories;

import com.hhplus.hhplus3week.app.payment.models.Payment;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {


    //TODO: payment? money?  어느쪽에서 구현하는게 맞는지
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM Payment p WHERE p.id = :id")
    Payment findByIdWithLock(Long id);
}
