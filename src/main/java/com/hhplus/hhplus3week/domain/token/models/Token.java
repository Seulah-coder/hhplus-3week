package com.hhplus.hhplus3week.domain.token.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TOKEN")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "TOKEN_STATUS")
    private String tokenStatus;

    @Column(name = "WAITING_INDEX")
    private Long waitingIndex;

    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime;

    @Column(name = "UPDATE_TIME")
    private LocalDateTime updateTime;

    @Column(name = "EXPIRE_TIME")
    private LocalDateTime expireTime;


}
