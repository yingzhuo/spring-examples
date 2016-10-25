package com.github.yingzhuo.spring.examples.https;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @RequestMapping(value = "/ssl", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> ssl(HttpServletRequest request) {
        final Map<String, Object> map = new HashMap<>();

        final Map<String, List<String>> parameters = new HashMap<>();
        request.getParameterMap().keySet().forEach(key -> {
            String[] value = request.getParameterMap().get(key);
            parameters.put(key, Arrays.asList(value));
        });

        final Map<String, String> headers = new HashMap<>();
        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            headers.put(name, value);
        }

        map.put("path", request.getRequestURI());
        map.put("parameters", parameters);
        map.put("headers", headers);
        return map;
    }

}
