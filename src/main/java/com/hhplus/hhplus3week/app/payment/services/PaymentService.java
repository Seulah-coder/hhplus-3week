package com.hhplus.hhplus3week.app.payment.services;

import com.hhplus.hhplus3week.app.common.JwtProvider;
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

    private final JwtProvider jwtProvider;

    @Transactional
    public Payment savePayment(PaymentRequestDTO paymentRequestDTO) {

        if(jwtProvider.validateToken(paymentRequestDTO.getToken(), paymentRequestDTO.getUserId())){
            Payment payment = Payment.builder()
                    .id(paymentRequestDTO.getId())
                    .paymentTime(LocalDateTime.now())
                    .amount(paymentRequestDTO.getAmount())
                    .userId(paymentRequestDTO.getUserId())
                    .build();
            return paymentRepository.save(payment);
        } else {
            throw new RuntimeException("유효한 토큰이 아닙니다.");
        }
    }

    public Payment getPayment(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디에 해당하는 페이먼트 없음"));
    }
}
