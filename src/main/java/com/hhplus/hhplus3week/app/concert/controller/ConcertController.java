package com.hhplus.hhplus3week.app.concert.controller;

import com.hhplus.hhplus3week.app.concert.dto.ConcertDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/concert")
@Tag(name = "콘서트 api")
public class ConcertController {

    /**
     * 콘서트 목록 조회
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<ConcertDTO>> getAllConcertList(){
        List<ConcertDTO> concertList = List.of();
        return ResponseEntity.ok(concertList);
    }

    /**
     * 콘서트 조회
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConcertDTO> getConcertById(@PathVariable("id") Long concertId){
        ConcertDTO concert = new ConcertDTO();
        return ResponseEntity.ok(concert);
    }
}
