package com.hhplus.hhplus3week.app.payment.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentRequestDTO {

    private Long id;
    private Long userId;
    private Long bookingId;
    private int amount;
    private LocalDateTime paymentTime;
}
