package com.hhplus.hhplus3week.app.domain.seat.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_seat")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long concertScheduleId;

    private Long seatNumber;

    private int price;

    private String seatStatus;

    private Long tempUserId;

    private Long tempExpireTime;
}
