package com.cbl.backend.controller;


import com.cbl.backend.entity.Business;
import com.cbl.backend.mapper.BusinessMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static java.sql.DriverManager.println;

@RestController
public class BusinessControl {
    @Resource
    BusinessMapper businessMapper;

    @GetMapping("/business/info")
    public List<Business> list(){

        if (businessMapper.getAll()!=null) {
            return businessMapper.getAll();
        }
        else{
            println("No business");
            return null;
        }
    }
    @PostMapping("/business/{businessId}")
    public Business getBu(@PathVariable int businessId,HttpServletRequest request) {
        Business dbBus = businessMapper.getBusinessById(businessId);
        if (dbBus != null){
            HttpSession session = request.getSession();
            session.setAttribute("business", dbBus);
        }
        return dbBus;
    }

    @GetMapping("/business/getInfo")
    public Business getInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Business) session.getAttribute("business");
    }
}
