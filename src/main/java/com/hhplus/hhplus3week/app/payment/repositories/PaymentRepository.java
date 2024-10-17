package com.hhplus.hhplus3week.app.payment.repositories;

import com.hhplus.hhplus3week.app.payment.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
