package com.github.yingzhuo.spring.examples.event.controller;

import com.github.yingzhuo.spring.examples.event.custom.MyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @RequestMapping("test")
    public String test() {
        publisher.publishEvent(new MyEvent());
        return "OK";
    }

}
