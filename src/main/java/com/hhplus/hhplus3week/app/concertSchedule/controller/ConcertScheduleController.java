
package com.hhplus.hhplus3week.app.concertSchedule.controller;

import com.hhplus.hhplus3week.app.concertSchedule.dto.ConcertScheduleDTO;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/concertSchedules")
@Tag(name = "콘서트 스케줄 api")
public class ConcertScheduleController {

    /**
     * 콘서트 아이디에 따른 콘서트 스케줄 내용을 조회한다.
     * @return
     */
    @GetMapping("/{concertId}")
    public ResponseEntity<List<ConcertScheduleDTO>> getConcertScheduleListByConcertId(@PathVariable("concertId") Long concertId){
        List<ConcertScheduleDTO> concertScheduleList = List.of();
        return ResponseEntity.ok(concertScheduleList);
    }

    /**
     * 아이디에 따른 특정 콘서트 상세 정보를 조회한다.
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<ConcertScheduleDTO> getConcertScheduleById(@PathVariable("id") Long id){
        ConcertScheduleDTO concert = new ConcertScheduleDTO();
        return ResponseEntity.ok(concert);
    }
}
