package com.hhplus.hhplus3week.app.concert.controller;

import com.hhplus.hhplus3week.app.concert.dto.ConcertSaveDTO;
import com.hhplus.hhplus3week.app.concert.dto.ConcertSearchDTO;
import com.hhplus.hhplus3week.app.concert.models.Concert;
import com.hhplus.hhplus3week.app.concert.services.ConcertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concerts")
@Tag(name = "콘서트 api")
@AllArgsConstructor
public class ConcertController {

    private final ConcertService concertService;

    @PostMapping("/")
    public ResponseEntity<Concert> saveConcert(@RequestBody ConcertSaveDTO concertSaveDTO) {
        Concert concert = concertService.saveConcert(concertSaveDTO);
        return ResponseEntity.ok(concert);
    }

    /**
     * 콘서트 목록 조회
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Concert>> getAllConcertList(ConcertSearchDTO concertSearchDTO){
        List<Concert> concertList = concertService.getAllConcertList();
        return ResponseEntity.ok(concertList);
    }

    /** TODO: facade 이용하지 않음
     * 콘서트 조회
     * @return
     */
    @GetMapping("/{concertId}/schedules")
    public ResponseEntity<Concert> getConcertById(@PathVariable("concertId") Long concertId){
        Concert concert = concertService.getConcertIdWithScheduleByConcertId(concertId);
        return ResponseEntity.ok(concert);
    }


}
