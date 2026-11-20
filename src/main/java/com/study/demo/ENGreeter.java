package com.study.demo;

public class ENGreeter implements Greeter {
    @Override
    public String greet(String name) {
        return "Hello " + name + "!";
    }
}
