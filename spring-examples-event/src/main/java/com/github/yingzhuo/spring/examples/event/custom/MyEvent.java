package com.github.yingzhuo.spring.examples.event.custom;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    private static final Object NULL = new Object() {
        @Override
        public String toString() {
            return "My Event Source.";
        }
    };

    public MyEvent() {
        this(NULL);
    }

    public MyEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "My Custome Event";
    }

}
