package com.hhplus.hhplus3week.domain.seat.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_SEAT")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CONCERT_SCHEDULE_ID")
    private Long concertScheduleId;

    @Column(name = "SEAT_NUMBER")
    private Long seatNumber;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "SEAT_STATUS")
    private String seatStatus;

    @Column(name = "TEMP_USER_ID")
    private Long tempUserId;

    @Column(name = "TEMP_EXPIRE_TIME")
    private Long tempExpireTime;
}
