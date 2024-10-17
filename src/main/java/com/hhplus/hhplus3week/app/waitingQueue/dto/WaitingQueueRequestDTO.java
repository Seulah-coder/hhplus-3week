package com.hhplus.hhplus3week.app.waitingQueue.dto;

import lombok.Data;

@Data
public class WaitingQueueRequestDTO {

    private Long id;
    private Long userId;
    private Long concertId;
    private String Token;
}
