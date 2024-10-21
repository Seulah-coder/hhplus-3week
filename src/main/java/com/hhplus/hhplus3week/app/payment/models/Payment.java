
package com.hhplus.hhplus3week.app.payment.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=30)
    private Long userId;

    @Column(length=30)
    private int amount;

    @Column(length=30)
    private String paymentStatus;

    @Column(length=100)
    private LocalDateTime paymentTime;


}
