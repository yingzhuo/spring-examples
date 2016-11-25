package com.github.yingzhuo.spring.examples.swagger.controller;

import com.github.yingzhuo.spring.examples.swagger.entity.User;
import com.github.yingzhuo.spring.examples.swagger.util.Json;
import io.swagger.annotations.*;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Profile("swagger")
public class UserMockController {

    private static final List<User> USERS = new ArrayList<>(2);

    static {
        USERS.add(new User("1", "应卓", "1234"));
        USERS.add(new User("2", null, "1234"));
    }

    @ApiOperation(value = "获取用户列表", notes = "获取铃铛所有用户的(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Token", value = "访问令牌", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "page", value = "页码 (从0开始) 默认0", required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每一页条目数 默认30", required = false, dataType = "int", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 201, message = "成功"),
            @ApiResponse(code = 401, message = "无法认证"),
            @ApiResponse(code = 403, message = "未经授权"),
            @ApiResponse(code = 404, message = "禁用"),
            @ApiResponse(code = 500, message = "系统异常")
    })
    @GetMapping(value = "/")
    public Json getUserList(@RequestParam(value = "page", required = false, defaultValue = "0") int pageNumber,
                            @RequestParam(value = "size", required = false, defaultValue = "30") int pageSize) {
        return Json.newInstace()
                .put("users", USERS);
    }

    @ApiOperation(value = "注册用户", notes = "注册用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "object", paramType = "body", example = "name:yingzhuo, password=1234")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 201, message = "成功"),
            @ApiResponse(code = 401, message = "无法认证"),
            @ApiResponse(code = 403, message = "未经授权"),
            @ApiResponse(code = 404, message = "禁用"),
            @ApiResponse(code = 500, message = "系统异常")
    })
    @PostMapping(value = "/")
    public Json regiesterUser(@RequestBody User user) {
        return Json.newInstace()
                .code(201);
    }

}
