package com.hhplus.hhplus3week.app.payment.dto;

import java.time.LocalDateTime;

public class PaymentDTO {

    private Long id;
    private Long userId;
    private Long bookingId;
    private int amount;
    private LocalDateTime paymentTime;
}
