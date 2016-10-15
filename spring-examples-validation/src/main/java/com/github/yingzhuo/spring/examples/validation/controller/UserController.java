package com.github.yingzhuo.spring.examples.validation.controller;

import com.github.yingzhuo.spring.examples.validation.controller.request.UserRequest;
import com.github.yingzhuo.spring.examples.validation.jsr310.ValidationGroup;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @PostMapping
    public String createUser(
            @Validated(ValidationGroup.Create.class) @RequestBody UserRequest userRequest,
            BindingResult bindingResult
            )
    {

        if (bindingResult.hasErrors()) {
            //TODO: 数据验证不能通过 抛异常
        }

        return "ok";
    }

}
