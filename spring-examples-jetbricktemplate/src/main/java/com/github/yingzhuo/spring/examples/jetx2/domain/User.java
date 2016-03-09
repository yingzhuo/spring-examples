package com.github.yingzhuo.spring.examples.jetx2.domain;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private Gender gender;
    private String comment;

    public User() {
        super();
    }

    public User(String name, Gender gender, String comment) {
        this.name = name;
        this.gender = gender;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
