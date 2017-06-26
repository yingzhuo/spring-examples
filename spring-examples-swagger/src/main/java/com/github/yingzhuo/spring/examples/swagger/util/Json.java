/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **    |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
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
