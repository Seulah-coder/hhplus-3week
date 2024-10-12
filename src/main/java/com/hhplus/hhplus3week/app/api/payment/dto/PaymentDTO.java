package com.hhplus.hhplus3week.app.api.payment.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDTO {

    private Long id;
    private Long userId;
    private Long bookingId;
    private int amount;
    private LocalDateTime paymentTime;
}
