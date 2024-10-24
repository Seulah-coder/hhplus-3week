package com.hhplus.hhplus3week.app.waitingQueue.services;

import com.hhplus.hhplus3week.app.common.JwtProvider;
import com.hhplus.hhplus3week.app.waitingQueue.dto.ConcertWaitingCheckDTO;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import com.hhplus.hhplus3week.app.waitingQueue.dto.WaitingQueueRequestDTO;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingStatus;
import com.hhplus.hhplus3week.app.waitingQueue.repositories.WaitingQueueRepository;
import io.jsonwebtoken.JwtException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class WaitingQueueService {

    private final WaitingQueueRepository waitingQueueRepository;

    private final JwtProvider jwtProvider;

    @Transactional
    public WaitingQueue saveWaitingQueue(WaitingQueueRequestDTO waitingQueueRequestDTO){

        String token = this.createToken(waitingQueueRequestDTO.getUserId());
        int waitingOrder = this.checkMaxWaitingOrderByConcertId(waitingQueueRequestDTO.getConcertId());
        WaitingQueue newWaitingQueue = WaitingQueue.builder()
                .id(waitingQueueRequestDTO.getId())
                .concertId(waitingQueueRequestDTO.getConcertId())
                .userId(waitingQueueRequestDTO.getUserId())
                .token(token)
                .tokenStatus(waitingQueueRequestDTO.getTokenStatus())
                .waitingIndex(waitingOrder)
                .waitingStatus(WaitingStatus.WAITING)
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
                    .id(waitingQueue.getId())
                    .concertId(waitingQueue.getConcertId())
                    .userId(waitingQueue.getUserId())
                    .token(token)
                    .tokenStatus(waitingQueueRequestDTO.getTokenStatus())
                    .waitingIndex(waitingOrder)
                    .updateTime(LocalDateTime.now())
                    .waitingStatus(waitingQueueRequestDTO.getWaitingStatus())
                    .build();

            return waitingQueueRepository.save(newWaitingQueue);
        } else {
            throw new JwtException("Invalid token");
        }
    }

    @Transactional
    public ConcertWaitingCheckDTO checkWaitingQueueByConcertId(Long concertId, Long userId) {
        ConcertWaitingCheckDTO response = new ConcertWaitingCheckDTO();

        try {
            boolean hasWaitingOrder = this.checkWaitingOrderByConcertId(concertId) > 0;
            WaitingQueue waitingQueue = this.getWaitingQueueByUserId(userId);

            // 대기열이 없을 때 콘서트 정보를 바로 반환
            if (!hasWaitingOrder) {
                response.setWaitingQueteStatus(WaitingStatus.PASS);
                return response;
            }

            // 대기열이 있지만 유저가 대기열에 없는 경우, 새로운 대기열 생성
            if (waitingQueue == null) {
                WaitingQueueRequestDTO waitingQueueRequestDTO = new WaitingQueueRequestDTO();
                waitingQueueRequestDTO.setConcertId(concertId);
                waitingQueueRequestDTO.setUserId(userId);
                WaitingQueue createQueue = this.saveWaitingQueue(waitingQueueRequestDTO);
                response.setWaitingQueteStatus(WaitingStatus.WAITING);
                response.setToken(createQueue.getToken());
                return response;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    public void updateWaitingQueueRank(Long concertId, LocalDateTime time){
        waitingQueueRepository.updateWaitingQueueRank(concertId, time);
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

    public int deleteWaitingQueue(LocalDateTime time){
        return waitingQueueRepository.deleteExpiredWaitingQueue(time);
    }

    public List<Long> findDistinctConcertIds(){
        return waitingQueueRepository.findDistinctConcertIds();
    }


    private String createToken(Long userId){
        return jwtProvider.createAccessToken(userId);
    }


    public void deleteWaitingQueueById(Long id) {
        waitingQueueRepository.deleteById(id);
    }
}
