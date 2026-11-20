package com.study.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //웹 요청을 받아서 응답 돌려주는 표시
public class HelloController {

    @GetMapping("/hello") //이 주소로 get 이 오면 아래 매서드를 수행
    public String hello(@RequestParam(defaultValue = "손님") String name){ //주소 뒤의 ?name= 을 변수로 받음
            return "안녕하세요, " + name + "님!";
    }
    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "kr") String lang,
                       @RequestParam(defaultValue = "손님") String name){
        Greeter krGreeter = new KRGreeter();
        Greeter enGreeter = new ENGreeter();
        switch (lang) {
            case "kr":
                return krGreeter.greet(name);

            case "en":
                return enGreeter.greet(name);

            default:
                return krGreeter.greet(name);

        }
    }
}
