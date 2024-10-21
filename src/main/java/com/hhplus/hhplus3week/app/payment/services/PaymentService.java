package com.hhplus.hhplus3week.app.payment.services;

import com.hhplus.hhplus3week.app.payment.dto.PaymentRequestDTO;
import com.hhplus.hhplus3week.app.payment.models.Payment;
import com.hhplus.hhplus3week.app.payment.repositories.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment savePayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = Payment.builder()
                .paymentTime(LocalDateTime.now())
                .amount(paymentRequestDTO.getAmount())
                .userId(paymentRequestDTO.getUserId())
                .build();
        return paymentRepository.save(payment);
    }

    @Transactional
    public Payment updatePayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = Payment.builder()
                .id(paymentRequestDTO.getId())
                .paymentTime(LocalDateTime.now())
                .amount(paymentRequestDTO.getAmount())
                .userId(paymentRequestDTO.getUserId())
                .build();
        return paymentRepository.save(payment);
    }

    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디에 해당하는 페이먼트 없음"));
    }
}
