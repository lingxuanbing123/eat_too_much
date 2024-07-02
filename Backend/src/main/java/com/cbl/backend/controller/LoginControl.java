package com.cbl.backend.controller;

import com.cbl.backend.entity.User;
import com.cbl.backend.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginControl {
    @Resource
    UserMapper userMapper;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User dbUser = userMapper.getUserByNameAndPasswd(user.getUser_name(), user.getPassword());
        return dbUser;
    }
}
