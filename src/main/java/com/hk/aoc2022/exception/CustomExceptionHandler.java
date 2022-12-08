package com.hk.aoc2022.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(DefaultException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleDefaultException(DefaultException e) {
        return Mono.just(ResponseEntity.status(e.getCode()).body(ErrorResponse.create(e.getCause(), e.getCode(), e.getMessage())));
    }
}
