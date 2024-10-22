package com.hhplus.hhplus3week.app.payment.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentRequestDTO {

    private Long id;
    private Long userId;
    private Long bookingId;
    private int amount;
    private String seatPrice;
    private LocalDateTime paymentTime;
    private String token;
}
