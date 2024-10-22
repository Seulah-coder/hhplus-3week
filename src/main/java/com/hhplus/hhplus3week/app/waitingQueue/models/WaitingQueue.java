package com.hhplus.hhplus3week.app.waitingQueue.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "waitingQueue")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaitingQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=30)
    private Long id;

    @Column(length=30)
    private Long userId;

    @Column(length=30)
    private Long concertId;

    @Column(length=30)
    private String token;

    @Column(length=30)
    private String tokenStatus;

    @Column(length=30)
    private String waitingStatus;

    @Column(length=30)
    private int waitingIndex;

    @Column(length=100)
    private String uuid;

    @Column(length=100)
    private LocalDateTime createTime;

    //TODO: 가능한지 조회할 때 마다 update 해줌
    @Column(length=100)
    private LocalDateTime updateTime;

    @Column(length=100)
    private LocalDateTime expireTime;


}
