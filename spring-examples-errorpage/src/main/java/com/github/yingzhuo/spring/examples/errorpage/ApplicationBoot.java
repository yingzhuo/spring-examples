package com.github.yingzhuo.spring.examples.errorpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @GetMapping("/borken")
    public String borken(ModelMap modelMap) {
        throw new UnsupportedOperationException("暂不支持");
    }

}
