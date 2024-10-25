package com.hhplus.hhplus3week.app.waitingQueue.services;

import com.hhplus.hhplus3week.app.concert.dto.ConcertSaveDTO;
import com.hhplus.hhplus3week.app.concert.repositories.ConcertRepository;
import com.hhplus.hhplus3week.app.concert.services.ConcertService;
import com.hhplus.hhplus3week.app.waitingQueue.dto.ConcertWaitingCheckDTO;
import com.hhplus.hhplus3week.app.waitingQueue.dto.WaitingQueueRequestDTO;
import com.hhplus.hhplus3week.app.waitingQueue.repositories.WaitingQueueRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WaitingQueueServiceTest {

    @InjectMocks
    WaitingQueueService waitingQueueService;

    @InjectMocks
    ConcertService concertService;

    @Mock
    ConcertRepository concertRepository;

    @Mock
    WaitingQueueRepository waitingQueueRepository;

    @Test
    void checkWaitingQueueByConcertId() {

        Long concertId = 1L;
        Long userId = 1L;

        ConcertSaveDTO concertSaveDTO = new ConcertSaveDTO();
        concertSaveDTO.setId(1L);
        concertSaveDTO.setName("name");
        concertSaveDTO.setSinger("test");
        concertService.saveConcert(concertSaveDTO);

        WaitingQueueRequestDTO waitingQueueRequestDTO = new WaitingQueueRequestDTO();
        waitingQueueRequestDTO.setUserId(2L);
        waitingQueueRequestDTO.setConcertId(concertId);
        waitingQueueService.saveWaitingQueue(waitingQueueRequestDTO);

        WaitingQueueRequestDTO waitingQueueRequestDTO1 = new WaitingQueueRequestDTO();
        waitingQueueRequestDTO1.setUserId(3L);
        waitingQueueRequestDTO1.setConcertId(concertId);
        waitingQueueService.saveWaitingQueue(waitingQueueRequestDTO1);

        WaitingQueueRequestDTO waitingQueueRequestDTO2 = new WaitingQueueRequestDTO();
        waitingQueueRequestDTO2.setUserId(4L);
        waitingQueueRequestDTO2.setConcertId(concertId);
        waitingQueueService.saveWaitingQueue(waitingQueueRequestDTO2);

        WaitingQueueRequestDTO waitingQueueRequestDTO3 = new WaitingQueueRequestDTO();
        waitingQueueRequestDTO3.setUserId(5L);
        waitingQueueRequestDTO3.setConcertId(concertId);
        waitingQueueService.saveWaitingQueue(waitingQueueRequestDTO3);

        WaitingQueueRequestDTO waitingQueueRequestDTO4 = new WaitingQueueRequestDTO();
        waitingQueueRequestDTO4.setUserId(6L);
        waitingQueueRequestDTO4.setConcertId(concertId);
        waitingQueueService.saveWaitingQueue(waitingQueueRequestDTO4);



        ConcertWaitingCheckDTO response  = waitingQueueService.checkWaitingQueueByConcertId(concertId, userId);
        System.out.println("response = " + response);
    }

    @Test
    void updateWaitingQueueRank() {
    }

    @Test
    void getWaitingQueueByUserId() {
    }

    @Test
    void getWaitingQueueById() {
    }

    @Test
    void checkMaxWaitingOrderByConcertId() {
    }

    @Test
    void checkWaitingOrderByConcertId() {
    }

    @Test
    void deleteWaitingQueue() {
    }

    @Test
    void findDistinctConcertIds() {
    }

    @Test
    void countByConcertId() {
    }

    @Test
    void deleteWaitingQueueById() {
    }
}