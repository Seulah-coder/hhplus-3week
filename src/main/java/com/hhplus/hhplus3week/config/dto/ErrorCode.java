package com.hhplus.hhplus3week.config.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ErrorCode {
    HttpStatus getHttpStatus;
    String message;
}
