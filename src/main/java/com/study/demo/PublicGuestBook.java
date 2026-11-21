package com.study.demo;

import org.springframework.stereotype.Component;


public class PublicGuestBook extends GuestbookEntry{
    public PublicGuestBook(String name, String message) {
        super(name, message);
    }
}
