package com.cbl.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cbl.backend.entity.User;

import javax.annotation.Resource;
@RestController
public class RegisterControl
{

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return user;
    }
}
