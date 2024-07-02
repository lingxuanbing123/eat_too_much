package com.cbl.backend.controller;

import com.cbl.backend.entity.User;
import com.cbl.backend.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@RestController
public class LoginControl {
    @Resource
    UserMapper userMapper;

    @PostMapping("/login")
    public User login(@RequestBody User user, HttpServletRequest request) {
        User dbUser = userMapper.getUserByNameAndPasswd(user.getUsername(), user.getPassword());
        if (dbUser != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", dbUser);
        }
        return dbUser;
    }
    @GetMapping("/info")
    public User getUserInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (User) session.getAttribute("user");
    }
}

