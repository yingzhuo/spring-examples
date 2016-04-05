package com.github.yingzhuo.spring.examples.event.custom;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener(MyEvent.class)
    public void handleMyEvent(MyEvent e) {
        System.out.println(e.getSource());
    }

}
