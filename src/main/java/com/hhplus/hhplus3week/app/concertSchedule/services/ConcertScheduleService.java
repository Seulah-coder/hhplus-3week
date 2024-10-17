package com.hhplus.hhplus3week.app.concertSchedule.services;

import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import com.hhplus.hhplus3week.app.concertSchedule.repositories.ConcertScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConcertScheduleService {

    private final ConcertScheduleRepository concertScheduleRepository;

    public ConcertSchedule saveConcertSchedule(ConcertSchedule concertSchedule) {
        return concertScheduleRepository.save(concertSchedule);
    }
    public ConcertSchedule getConcertScheduleById(Long id) {
        return concertScheduleRepository.findById(id).orElse(null);
    }
    public ConcertSchedule getConcertScheduleByIdWithSeats(Long concertId) {
        return concertScheduleRepository.findByIdWithSeats(concertId);
    }
}
