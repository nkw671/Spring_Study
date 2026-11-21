package com.study.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GuestBookNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFound(GuestBookNotFoundException e) {
        return ResponseEntity.status(404)
                .body(new ErrorMessage(e.getMessage()));
    }
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ErrorMessage> handleIncorrectPassword(IncorrectPasswordException e) {
        return ResponseEntity.status(403)
                .body(new ErrorMessage(e.getMessage()));
    }



}


