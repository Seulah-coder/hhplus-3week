package com.hhplus.hhplus3week.app.concert.services;

import com.hhplus.hhplus3week.app.concert.dto.ConcertSaveDTO;
import com.hhplus.hhplus3week.app.concert.models.Concert;
import com.hhplus.hhplus3week.app.concert.repositories.ConcertRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConcertService {

    private final ConcertRepository concertRepository;

    @Transactional
    public Concert saveConcert(ConcertSaveDTO concertSaveDTO){
        Concert concert = Concert.builder()
                .singer(concertSaveDTO.getSinger())
                .name(concertSaveDTO.getName())
                .build();
        return concertRepository.save(concert);
    }

    public List<Concert> getAllConcertList(){
        return concertRepository.findAll();
    }

    public Concert getConcertById(Long concertId){
        return concertRepository.findById(concertId).orElseThrow(() -> new IllegalArgumentException("No concert found with id: " + concertId));
    }

    public Concert getConcertIdWithScheduleByConcertId(Long concertId) {
         return concertRepository.findByIdWithSchedules(concertId);
    }
}
