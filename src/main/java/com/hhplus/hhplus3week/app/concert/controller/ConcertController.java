package com.hhplus.hhplus3week.app.concert.controller;

import com.hhplus.hhplus3week.app.concert.dto.ConcertDTO;
import com.hhplus.hhplus3week.app.concert.models.Concert;
import com.hhplus.hhplus3week.app.concert.services.ConcertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concerts")
@Tag(name = "콘서트 api")
public class ConcertController {

    private final ConcertService concertService;

    public ConcertController(ConcertService concertService) {
        this.concertService = concertService;
    }

    /**
     * 콘서트 목록 조회
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<ConcertDTO>> getAllConcertList(){
        List<ConcertDTO> concertList = List.of();
        return ResponseEntity.ok(concertList);
    }

    /**
     * 콘서트 조회
     * @return
     */
    @GetMapping("/{concertId}")
    public ResponseEntity<ConcertDTO> getConcertById(@PathVariable("concertId") Long concertId){
        ConcertDTO concert = new ConcertDTO();
        return ResponseEntity.ok(concert);
    }

    /**
     * 콘서트 조회
     * @return
     */
    @GetMapping("/{concertId}/schedules/{scheduleId}")
    public ResponseEntity<Concert> getConcertById(@PathVariable("concertId") Long concertId, @PathVariable("scheduleId") Long concertScheduleId, @RequestParam("token") String token){
        Concert concert = concertService.getConcertWithSchedulesById(concertId);
        return ResponseEntity.ok(concert);
    }

}
