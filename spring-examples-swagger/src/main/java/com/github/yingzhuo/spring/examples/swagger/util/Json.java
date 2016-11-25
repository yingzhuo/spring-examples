package com.github.yingzhuo.spring.examples.swagger.util;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Json implements Serializable {

    private static final long serialVersionUID = 186955837866831167L;

    public static Json newInstace() {
        return new Json();
    }

    private int code = 200;
    private String message = "";
    private final Map<String, Object> datas = new HashMap<>();

    private Json() {}

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Json code(int code) {
        this.code = code;
        return this;
    }

    public Json message(String message) {
        this.message = message;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getDatas() {
        return datas;
    }

    public Json put(String key, Object value) {
        datas.put(key, value);
        return this;
    }

}
