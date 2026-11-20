package com.study.demo;

import org.springframework.stereotype.Component;


@Component("ja")
public class JAGreeter implements Greeter {
    @Override
    public String greet(String name) {
        return "こんにちは、" + name + " さん!";
    }
}