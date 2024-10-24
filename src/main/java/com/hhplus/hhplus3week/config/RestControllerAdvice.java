package com.hhplus.hhplus3week.config;

import com.hhplus.hhplus3week.config.dto.ErrorCode;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;

@ControllerAdvice
class RestControllerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorCode> handleIllegalArgumentException(
            IllegalArgumentException e, WebRequest request) {

        return createErrorResponse(e, request, HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorCode> handleAuthenticationException(
            AuthenticationException e, WebRequest request) {

        return createErrorResponse(e, request, HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorCode> handleAccessDeniedException(
            AccessDeniedException e, WebRequest request) {

        return createErrorResponse(e, request, HttpStatus.FORBIDDEN, e.getMessage());
    }

    @ExceptionHandler({NoSuchElementException.class, EntityNotFoundException.class})
    public ResponseEntity<ErrorCode> handleNotFoundExceptions(
            Exception e, WebRequest request) {
        return createErrorResponse(e, request, HttpStatus.NOT_FOUND, "Resource not found");
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorCode> handleIllegalStateException(
            IllegalStateException e, WebRequest request) {

        return createErrorResponse(e, request, HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorCode> handleGenericException(Exception e, WebRequest request) {
        return createErrorResponse(e, request, HttpStatus.INTERNAL_SERVER_ERROR, "시스템 오류");
    }

    private ResponseEntity<ErrorCode> createErrorResponse(
            Exception e, WebRequest request, HttpStatus status, String message) {

        ErrorCode ErrorCode = new ErrorCode(status, message);
        return ResponseEntity.status(status).body(ErrorCode);
    }

}

