package com.study.demo;

public class GuestBookNotFoundException extends RuntimeException{
    public GuestBookNotFoundException(String message) {
        super(message);
    }
}
