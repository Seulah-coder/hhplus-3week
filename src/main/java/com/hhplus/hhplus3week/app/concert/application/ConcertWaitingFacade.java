package com.hhplus.hhplus3week.app.concert.application;

import com.hhplus.hhplus3week.app.common.JwtProvider;
import com.hhplus.hhplus3week.app.concert.dto.ConcertWaitingCheckDTO;
import com.hhplus.hhplus3week.app.concert.models.Concert;
import com.hhplus.hhplus3week.app.concert.services.ConcertService;
import com.hhplus.hhplus3week.app.waitingQueue.dto.WaitingQueueRequestDTO;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import com.hhplus.hhplus3week.app.waitingQueue.services.WaitingQueueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConcertWaitingFacade {

    private final ConcertService concertService;
    private final WaitingQueueService waitingQueueService;
    private final JwtProvider jwtProvider;

    public ConcertWaitingCheckDTO checkWaitingQueueGetConcertById(Long concertId, Long userId){
        ConcertWaitingCheckDTO response = new ConcertWaitingCheckDTO();
        WaitingQueue waitingQueue = waitingQueueService.getWaitingQueueByUserId(userId);
        if(waitingQueue == null){
            WaitingQueueRequestDTO waitingQueueRequestDTO = new WaitingQueueRequestDTO();
            waitingQueueRequestDTO.setConcertId(concertId);
            waitingQueueRequestDTO.setUserId(userId);
            waitingQueue = waitingQueueService.saveWaitingQueue(waitingQueueRequestDTO);
            response.setWaitingQueue(waitingQueue);
        } else if(waitingQueue.getTokenStatus().equals("pass")){
            response.setConcert(concertService.getConcertById(concertId));
        }
        return response;
    }
}
