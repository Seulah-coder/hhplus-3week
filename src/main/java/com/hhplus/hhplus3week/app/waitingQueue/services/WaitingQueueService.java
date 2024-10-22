package com.hhplus.hhplus3week.app.waitingQueue.services;

import com.hhplus.hhplus3week.app.common.JwtProvider;
import com.hhplus.hhplus3week.app.waitingQueue.dto.WaitingQueueRequestDTO;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import com.hhplus.hhplus3week.app.waitingQueue.repositories.WaitingQueueRepository;
import io.jsonwebtoken.JwtException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class WaitingQueueService {

    private final WaitingQueueRepository waitingQueueRepository;

    private final JwtProvider jwtProvider;

    @Transactional
    public WaitingQueue createWaitingQueue(WaitingQueueRequestDTO waitingQueueRequestDTO){

        String token = this.createToken(waitingQueueRequestDTO.getUserId());
        int waitingOrder = this.checkMaxWaitingOrderByConcertId(waitingQueueRequestDTO.getConcertId());
        WaitingQueue newWaitingQueue = WaitingQueue.builder()
                .id(waitingQueueRequestDTO.getId())
                .concertId(waitingQueueRequestDTO.getConcertId())
                .userId(waitingQueueRequestDTO.getUserId())
                .token(token)
                .tokenStatus(waitingQueueRequestDTO.getTokenStatus())
                .waitingIndex(waitingOrder)
                .createTime(LocalDateTime.now())
                .build();

        return waitingQueueRepository.save(newWaitingQueue);
    }

    @Transactional
    public WaitingQueue updateWaitingQueue(WaitingQueueRequestDTO waitingQueueRequestDTO){

        WaitingQueue waitingQueue = this.getWaitingQueueById(waitingQueueRequestDTO.getId());
        String token = waitingQueue.getToken();
        int waitingOrder = waitingQueue.getWaitingIndex();
        if(jwtProvider.validateToken(token, waitingQueue.getUserId())){
            WaitingQueue newWaitingQueue = WaitingQueue.builder()
                    .id(waitingQueueRequestDTO.getId())
                    .concertId(waitingQueueRequestDTO.getConcertId())
                    .userId(waitingQueueRequestDTO.getUserId())
                    .token(token)
                    .tokenStatus(waitingQueueRequestDTO.getTokenStatus())
                    .waitingIndex(waitingOrder)
                    .updateTime(LocalDateTime.now())
                    .build();

            return waitingQueueRepository.save(newWaitingQueue);
        } else {
            throw new JwtException("Invalid token");
        }
    }

    public WaitingQueue getWaitingQueueByUserId(Long userId){
        return waitingQueueRepository.findByUserId(userId);
    }

    public WaitingQueue getWaitingQueueById(Long id){
        return waitingQueueRepository.findById(id).orElseThrow(() -> new RuntimeException("해당하는 큐 없음"));
    }


    public int checkMaxWaitingOrderByConcertId(Long concertId){
        return waitingQueueRepository.findMaxWaitingIndex(concertId);
    }

    public int checkWaitingOrderByConcertId(Long concertId){
        return waitingQueueRepository.findAllByConcertId(concertId).size();
    }


    private String createToken(Long userId){
        return jwtProvider.createAccessToken(userId);
    }
}
