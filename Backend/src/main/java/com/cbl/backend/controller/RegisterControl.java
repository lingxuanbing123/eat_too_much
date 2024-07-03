package com.cbl.backend.controller;

import com.cbl.backend.mapper.RegisterMapper;
import com.cbl.backend.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cbl.backend.entity.User;

import javax.annotation.Resource;
@RestController
public class RegisterControl
{
    @Resource
    RegisterMapper registerMapper;
    @PostMapping("/register/save")
    public ResponseEntity<Void> save(@RequestBody User user){
        try {
            registerMapper.save(user);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
