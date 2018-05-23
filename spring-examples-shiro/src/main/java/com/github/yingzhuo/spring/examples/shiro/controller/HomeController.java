package com.github.yingzhuo.spring.examples.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 应卓
 */
@RestController
public class HomeController {

    @RequiresAuthentication
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
