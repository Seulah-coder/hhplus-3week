package com.hhplus.hhplus3week.app.money.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "moneyHistory")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MoneyHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=30)
    private Long userId;
    @Column(length=30)
    private int amountRecord;
    @Column(length=30)
    private String type;
    @Column(length = 100)
    private LocalDateTime createDate;
    @Column(length = 100)
    private LocalDateTime updateDate;
}
