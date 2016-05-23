package com.github.yingzhuo.spring.examples.redis.domain;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

    private String id = UUID.randomUUID().toString();
    private String name;

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
