package com.hhplus.hhplus3week.app.token.dto;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TokenDTO {

    private Long id;
    private Long userId;
    private String token;
    private String tokenStatus;
    private Long waitingIndex;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime expireTime;
}
