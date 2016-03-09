package com.github.yingzhuo.spring.examples.jetx2.controller;

import com.github.yingzhuo.spring.examples.jetx2.domain.Gender;
import com.github.yingzhuo.spring.examples.jetx2.domain.User;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "users")
public class UserController {

    @ModelAttribute("users")
    public List<User> users() {
        return ImmutableList.of(
                new User("陈国强", Gender.MALE, "大神"),
                new User("应卓", Gender.MALE, "抱大腿的男人")
        );
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUser() {
        return "users";
    }

}
