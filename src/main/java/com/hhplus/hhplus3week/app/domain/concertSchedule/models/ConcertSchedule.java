package com.hhplus.hhplus3week.app.domain.concertSchedule.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "concert_schedule")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConcertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=30)
    private Long concertId;
    @Column(length=100)
    private String concertPlace;
    @Column(length=100)
    private LocalDateTime openDatetime;
    @Column(length=100)
    private LocalDateTime ticketOpenDate;
}
