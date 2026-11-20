package com.study.demo;

public abstract class GuestbookEntry {
    protected String name;
    protected String message;


    public GuestbookEntry(String name, String message){
        this.name = name;
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
}
