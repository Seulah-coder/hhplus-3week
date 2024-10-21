package com.hhplus.hhplus3week.app.concert.controller;

import com.hhplus.hhplus3week.app.concert.application.ConcertWaitingFacade;
import com.hhplus.hhplus3week.app.concert.dto.ConcertSaveDTO;
import com.hhplus.hhplus3week.app.concert.dto.ConcertWaitingCheckDTO;
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
    private final ConcertWaitingFacade concertWaitingFacade;

    /**
     * 콘서트 목록 조회
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<ConcertSaveDTO>> getAllConcertList(){
        List<ConcertSaveDTO> concertList = List.of();
        return ResponseEntity.ok(concertList);
    }

    /**
     * 콘서트 조회
     * @return
     */
    @GetMapping("/{concertId}/schedules/{scheduleId}")
    public ResponseEntity<Concert> getConcertById(@PathVariable("concertId") Long concertId, @PathVariable("scheduleId") Long concertScheduleId, @RequestParam("token") String token){
        Concert concert = concertService.getConcertIdWithScheduleByConcertId(concertId);
        return ResponseEntity.ok(concert);
    }



    /** TODO: facade 이용
     * 콘서트 조회
     * @return
     */
    @GetMapping("/{concertId}/{userId}")
    public ResponseEntity<ConcertWaitingCheckDTO> getConcertById(@PathVariable("concertId") Long concertId, @PathVariable("userId") Long userId){
        ConcertWaitingCheckDTO concertCheck = concertWaitingFacade.checkWaitingQueueGetConcertById(concertId, userId);
        return ResponseEntity.ok(concertCheck);
    }

}
