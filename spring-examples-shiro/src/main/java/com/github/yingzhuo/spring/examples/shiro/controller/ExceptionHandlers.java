/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **    |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.shiro.controller;

import org.apache.shiro.ShiroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = {"com.github.yingzhuo.spring.examples.shiro.controller"})
public class ExceptionHandlers {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlers.class);

    private static final HttpHeaders JSON_HTTP_HEADERS;

    static {
        HttpHeaders json = new HttpHeaders();
        json.setContentType(MediaType.APPLICATION_JSON_UTF8);
        json.set("Pragma", "No-cache");
        json.set("Cache-Control", "No-cache");
        json.setDate("Expires", 0L);
        JSON_HTTP_HEADERS = HttpHeaders.readOnlyHttpHeaders(json);
    }

    @ExceptionHandler(ShiroException.class)
    public ResponseEntity<Map<String, Object>> handleShiroException(ShiroException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", "没有权限访问");
        return new ResponseEntity<>(map, JSON_HTTP_HEADERS, HttpStatus.FORBIDDEN);
    }

}
