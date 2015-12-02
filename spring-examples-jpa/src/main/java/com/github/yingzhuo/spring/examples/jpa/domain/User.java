package com.github.yingzhuo.spring.examples.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_USER")
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

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
