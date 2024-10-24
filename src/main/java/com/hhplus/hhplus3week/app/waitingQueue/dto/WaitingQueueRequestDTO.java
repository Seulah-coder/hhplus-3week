package com.hhplus.hhplus3week.app.waitingQueue.dto;

import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingStatus;
import lombok.Data;

@Data
public class WaitingQueueRequestDTO {

    private Long id;
    private Long userId;
    private Long concertId;
    private String Token;
    private String TokenStatus;
    private WaitingStatus waitingStatus;

}
