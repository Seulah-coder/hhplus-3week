package com.hhplus.hhplus3week.app.payment.services;

import com.hhplus.hhplus3week.app.common.JwtProvider;
import com.hhplus.hhplus3week.app.payment.dto.PaymentRequestDTO;
import com.hhplus.hhplus3week.app.payment.models.Payment;
import com.hhplus.hhplus3week.app.payment.models.PaymentStatus;
import com.hhplus.hhplus3week.app.payment.repositories.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @InjectMocks
    PaymentService paymentService;

    @Mock
    PaymentRepository paymentRepository;

    @Mock
    JwtProvider jwtProvider;


    @Test
    void savePayment() {

        PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
        paymentRequestDTO.setAmount(2000);
        paymentRequestDTO.setBookingId(1L);
        paymentRequestDTO.setUserId(1L);

        Payment payment = Payment.builder()
                .paymentStatus(PaymentStatus.PENDING)
                .amount(2000)
                .userId(1L)
                .build();

        when(paymentRepository.save(payment)).thenReturn(payment);

        Payment savedPayment = paymentService.savePayment(paymentRequestDTO);
        assertNotNull(savedPayment);
        assertEquals(paymentRequestDTO.getAmount(), savedPayment.getAmount());
        assertEquals(paymentRequestDTO.getUserId(), savedPayment.getUserId());
    }

    @Test
    void getPayment() {

        Payment payment = Payment.builder()
                .paymentStatus(PaymentStatus.PENDING)
                .amount(2000)
                .id(1L)
                .build();

        when(paymentRepository.findById(1L)).thenReturn(Optional.ofNullable(payment));

        Payment result = paymentService.getPayment(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }
}