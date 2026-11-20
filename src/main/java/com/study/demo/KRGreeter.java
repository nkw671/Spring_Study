package com.study.demo;

import org.springframework.stereotype.Component;

@Component("kr")
public class KRGreeter implements Greeter{

    @Override
    public String greet(String name) {
        return "안녕하세요 " + name + " 님!";
    }
}
