package com.hhplus.hhplus3week.app.domain.concertSchedule.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_concert_schedule")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConcertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long concertId;

    private String concertPlace;

    private LocalDateTime openDate;

    private LocalDateTime ticketOpenDate;
}
