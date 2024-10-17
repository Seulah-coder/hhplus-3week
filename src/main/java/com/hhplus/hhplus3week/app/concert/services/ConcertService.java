package com.hhplus.hhplus3week.app.concert.services;

import com.hhplus.hhplus3week.app.concert.models.Concert;
import com.hhplus.hhplus3week.app.concert.repositories.ConcertRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConcertService {

    private final ConcertRepository concertRepository;

    public Concert saveConcert(Concert concert){
        return concertRepository.save(concert);
    }

    public Concert getConcertById(Long concertId){
        return concertRepository.findById(concertId).orElseThrow(() -> new IllegalArgumentException("No concert found with id: " + concertId));
    }

    public Concert getConcertWithSchedulesById(Long concertId) {
         return concertRepository.findByIdWithSchedules(concertId);
    }
}
