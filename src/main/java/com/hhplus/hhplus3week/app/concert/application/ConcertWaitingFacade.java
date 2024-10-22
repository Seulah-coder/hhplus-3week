package com.hhplus.hhplus3week.app.concert.application;

import com.hhplus.hhplus3week.app.common.JwtProvider;
import com.hhplus.hhplus3week.app.concert.dto.ConcertWaitingCheckDTO;
import com.hhplus.hhplus3week.app.concert.services.ConcertService;
import com.hhplus.hhplus3week.app.waitingQueue.dto.WaitingQueueRequestDTO;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import com.hhplus.hhplus3week.app.waitingQueue.services.WaitingQueueService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConcertWaitingFacade {

    private final ConcertService concertService;
    private final WaitingQueueService waitingQueueService;
    private final JwtProvider jwtProvider;

    @Transactional
    public ConcertWaitingCheckDTO checkWaitingQueueGetConcertById(Long concertId, Long userId) {
        ConcertWaitingCheckDTO response = new ConcertWaitingCheckDTO();

        try {
            boolean hasWaitingOrder = waitingQueueService.checkWaitingOrderByConcertId(concertId) > 0;
            WaitingQueue waitingQueue = waitingQueueService.getWaitingQueueByUserId(userId);

            // 대기열이 없을 때 콘서트 정보를 바로 반환
            if (!hasWaitingOrder) {
                response.setConcert(concertService.getConcertIdWithScheduleByConcertId(concertId));
                return response;
            }

            // 대기열이 있지만 유저가 대기열에 없는 경우, 새로운 대기열 생성
            if (waitingQueue == null) {
                WaitingQueueRequestDTO waitingQueueRequestDTO = new WaitingQueueRequestDTO(concertId, userId);
                response.setWaitingQueue(waitingQueueService.createWaitingQueue(waitingQueueRequestDTO));
                return response;
            }

            // 대기열이 있고 토큰이 유효한 경우
            if (jwtProvider.validateToken(waitingQueue.getTokenStatus(), waitingQueue.getUserId())
                    && "pass".equals(waitingQueue.getTokenStatus())) {
                response.setConcert(concertService.getConcertIdWithScheduleByConcertId(concertId));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
