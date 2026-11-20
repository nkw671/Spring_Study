package com.study.demo;

import org.springframework.stereotype.Component;


@Component("en")
public class ENGreeter implements Greeter {
    @Override
    public String greet(String name) {
        return "Hello " + name + "!";
    }
}
