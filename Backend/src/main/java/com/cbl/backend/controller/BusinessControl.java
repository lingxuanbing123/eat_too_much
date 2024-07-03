package com.cbl.backend.controller;


import com.cbl.backend.entity.Business;
import com.cbl.backend.mapper.BusinessMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static java.sql.DriverManager.println;

@RestController
public class BusinessControl {
    @Resource
    BusinessMapper businessMapper;

    @GetMapping("/business/info")
    public List<Business> list(){
        if (businessMapper.getAll()!=null) {
            System.out.println(businessMapper.getAll());
            return businessMapper.getAll();
        }
        else{
            println("No business");
            return null;
        }
    }
}
