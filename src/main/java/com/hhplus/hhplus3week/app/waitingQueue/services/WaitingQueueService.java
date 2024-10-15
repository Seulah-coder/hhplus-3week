package com.hhplus.hhplus3week.app.waitingQueue.services;

import com.hhplus.hhplus3week.app.waitingQueue.dto.WaitingQueueRequestDTO;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import com.hhplus.hhplus3week.app.waitingQueue.repositories.WaitingQueueRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WaitingQueueService {

    private final WaitingQueueRepository waitingQueueRepository;

    @Transactional
    public WaitingQueue saveWaitingQueue(WaitingQueueRequestDTO waitingQueueRequestDTO){

        WaitingQueue newWaitingQueue = WaitingQueue.builder()
                .concertScheduleId(waitingQueueRequestDTO.getConcertScheduleId())
                .userId(waitingQueueRequestDTO.getUserId())
                .build();

        return waitingQueueRepository.save(newWaitingQueue);
    }

    public int checkWaitingOrder(Long concertScheduleId){
        List<WaitingQueue> checkQueue  = waitingQueueRepository.findAllByConcertScheduleId(concertScheduleId);
        return checkQueue.size();
    }

    private String createToken(Long userId){
        String token = "";
        return token;
    }
}
