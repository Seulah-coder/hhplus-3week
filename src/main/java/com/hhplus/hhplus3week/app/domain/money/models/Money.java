package com.hhplus.hhplus3week.app.domain.money.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "money")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Money {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=30)
    private Long userId;
    @Column(length=30)
    private int currentAmount;
}
