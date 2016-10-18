package com.github.yingzhuo.spring.examples.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectController {

    @GetMapping("/obj")
    public Object obj() {
        return ObjectController.class.getSimpleName();
    }

}
