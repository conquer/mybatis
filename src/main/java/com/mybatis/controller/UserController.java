package com.mybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.data.User;
import com.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xionggp on 17/4/1.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add")
    public JSONObject addUser(@RequestBody JSONObject user) {
        boolean success = userService.addUser(user);
        JSONObject result = new JSONObject();
        if (success) {
            result.put("ret", 0);
            result.put("msg", "success");
        } else {
            result.put("ret", 10000);
            result.put("msg", "fail");
        }
        result.put("serverTime", System.currentTimeMillis());
        return result;
    }

    @RequestMapping(value = "/update")
    public JSONObject updateUser(@RequestBody JSONObject user) {
        boolean success = userService.updateUser(user);
        JSONObject result = new JSONObject();
        if (success) {
            result.put("ret", 0);
            result.put("msg", "success");
        } else {
            result.put("ret", 10000);
            result.put("msg", "fail");
        }
        result.put("serverTime", System.currentTimeMillis());
        return result;
    }

    @RequestMapping(value = "/get")
    public JSONObject getUser(@RequestParam String username) {
        List<User> users = userService.getUsers(username);
        JSONObject result = new JSONObject();
        if (users != null) {
            result.put("ret", 0);
            result.put("user", users);
        } else {
            result.put("ret", 10000);
        }
        result.put("serverTime", System.currentTimeMillis());

        return result;
    }
}
