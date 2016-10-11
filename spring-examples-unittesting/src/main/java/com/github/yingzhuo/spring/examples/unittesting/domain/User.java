package com.github.yingzhuo.spring.examples.unittesting.domain;

import java.io.Serializable;

public class User implements Serializable {

    private String id;
    private String name;

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
