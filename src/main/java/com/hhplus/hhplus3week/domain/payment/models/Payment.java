package com.hhplus.hhplus3week.domain.payment.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PAYMENT")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "BOOKING_ID")
    private Long bookingId;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "PAYMENT_TIME")
    private LocalDateTime paymentTime;


}
