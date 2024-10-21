package com.hhplus.hhplus3week.app.waitingQueue.services;

import com.hhplus.hhplus3week.app.common.JwtProvider;
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

    private final JwtProvider jwtProvider;

    @Transactional
    public WaitingQueue saveWaitingQueue(WaitingQueueRequestDTO waitingQueueRequestDTO){

        WaitingQueue waitingQueue = this.getWaitingQueueByUserId(waitingQueueRequestDTO.getUserId());

        if(waitingQueue != null){
            return waitingQueue;
        } else {
            String token = this.createToken(waitingQueueRequestDTO.getUserId());
            int waitingOrder = this.checkWaitingOrderByConcertId(waitingQueueRequestDTO.getConcertId());

            WaitingQueue newWaitingQueue = WaitingQueue.builder()
                    .concertId(waitingQueueRequestDTO.getConcertId())
                    .userId(waitingQueueRequestDTO.getUserId())
                    .token(token)
                    .tokenStatus("wait")
                    .waitingIndex(waitingOrder)
                    .build();

            return waitingQueueRepository.save(newWaitingQueue);
        }
    }

    public WaitingQueue getWaitingQueueByUserId(Long userId){
        return waitingQueueRepository.findByUserId(userId);
    }

    public WaitingQueue getWaitingQueueById(Long id){
        return waitingQueueRepository.findById(id).orElse(null);
    }

    public int checkWaitingOrderByConcertId(Long concertId){
        List<WaitingQueue> checkQueue  = waitingQueueRepository.findAllByConcertId(concertId);
        return checkQueue.size();
    }

    private String createToken(Long userId){
        return jwtProvider.createAccessToken(userId);
    }
}
