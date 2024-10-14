package com.hhplus.hhplus3week.app.concertSchedule.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CONCERT_SCHEDULE")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConcertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CONCERT_ID")
    private Long concertId;

    @Column(name = "OPEN_DATE")
    private LocalDateTime openDate;

    @Column(name = "TICKET_OPEN_DATE")
    private LocalDateTime ticketOpenDate;
}
