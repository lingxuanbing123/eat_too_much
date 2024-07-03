package com.cbl.backend.controller;

import com.cbl.backend.mapper.GoodMapper;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GoodControl {
    @Resource
    GoodMapper goodMapper;
    public void tet(){

    }
}
