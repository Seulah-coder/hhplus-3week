package com.hhplus.hhplus3week.app.token.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "token")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=30)
    private Long id;

    @Column(length=30)
    private Long userId;

    private String token;

    @Column(length=30)
    private String tokenStatus;

    @Column(length=30)
    private Long waitingIndex;

    @Column(length=100)
    private LocalDateTime createTime;

    @Column(length=100)
    private LocalDateTime updateTime;

    @Column(length=100)
    private LocalDateTime expireTime;


}
