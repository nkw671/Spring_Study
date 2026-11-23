package com.study.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GuestBookNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFound(GuestBookNotFoundException e) {
        return ResponseEntity.status(404)
                .body(ApiResponse.error(e.getMessage()));
    }
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ApiResponse<Void>> handleIncorrectPassword(IncorrectPasswordException e) {
        return ResponseEntity.status(403)
                .body(ApiResponse.error(e.getMessage()));
    }



}


