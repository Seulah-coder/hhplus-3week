package com.hhplus.hhplus3week.app.domain.payment.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=30)
    private Long userId;

    @Column(length=30)
    private int amount;

    @Column(length=100)
    private LocalDateTime paymentTime;


}