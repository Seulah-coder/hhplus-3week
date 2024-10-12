package com.hhplus.hhplus3week.app.domain.token.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_token")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String token;

    private String tokenStatus;

    private Long waitingIndex;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private LocalDateTime expireTime;


}
