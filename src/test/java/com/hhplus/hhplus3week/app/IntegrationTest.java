package com.hhplus.hhplus3week.app;

import com.hhplus.hhplus3week.app.concert.application.ConcertWaitingFacade;
import com.hhplus.hhplus3week.app.concert.dto.ConcertSaveDTO;
import com.hhplus.hhplus3week.app.concert.dto.ConcertWaitingCheckDTO;
import com.hhplus.hhplus3week.app.concert.models.Concert;
import com.hhplus.hhplus3week.app.concert.services.ConcertService;
import com.hhplus.hhplus3week.app.concertSchedule.dto.ConcertScheduleSaveDTO;
import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import com.hhplus.hhplus3week.app.concertSchedule.services.ConcertScheduleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class IntegrationTest {

    @Autowired
    ConcertWaitingFacade concertWaitingFacade;

    @Autowired
    ConcertService concertService;

    @Autowired
    ConcertScheduleService concertScheduleService;


    @Test
    @DisplayName("콘서트 스케줄 조회 & 대기열을 조회한다.")
    void WaitingConcertTest(){
        Long userId = 1L;
        Long concertId = 1L;

        ConcertSaveDTO concertSaveDTO = new ConcertSaveDTO();
        concertSaveDTO.setId(1L);
        concertSaveDTO.setName("testConcert");
        concertSaveDTO.setSinger("IU");
        concertService.saveConcert(concertSaveDTO);

        LocalDateTime ticketDate = LocalDateTime.of(2024, 11, 30, 0, 0, 0);
        LocalDateTime releaseDate = LocalDateTime.of(2024, 12, 30, 9, 0 ,0);

        ConcertScheduleSaveDTO concertScheduleSaveDTO  = new ConcertScheduleSaveDTO();
        concertScheduleSaveDTO.setConcertPlace("일산 킨텍스");
        concertScheduleSaveDTO.setConcertId(1L);
        concertScheduleSaveDTO.setTotalSeatNumber(50);
        concertScheduleSaveDTO.setTicketOpenDate(ticketDate);
        concertScheduleSaveDTO.setConcertOpenDate(releaseDate);
        concertScheduleService.saveConcertSchedule(concertScheduleSaveDTO);


        ConcertWaitingCheckDTO data = concertWaitingFacade.checkWaitingQueueGetConcertById(concertId, userId);
        System.out.println("data = " + data);

    }
}
