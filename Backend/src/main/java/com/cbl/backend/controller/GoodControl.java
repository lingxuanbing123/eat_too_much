package com.cbl.backend.controller;

import com.cbl.backend.entity.Business;
import com.cbl.backend.entity.Good;
import com.cbl.backend.mapper.GoodMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.sql.DriverManager.println;

@RestController
public class GoodControl {
    @Resource
    GoodMapper goodMapper;

    @GetMapping("/good/info")
    public List<Good> getGoodByBusinessId(HttpServletRequest request){
        Business business = (Business) request.getSession().getAttribute("business");
        if(goodMapper.getGoodByBusinessId(business.getBusinessId()) != null){
            System.out.println(goodMapper.getGoodByBusinessId(business.getBusinessId()));
            return goodMapper.getGoodByBusinessId(business.getBusinessId());
        }
        else{
            println("没有该商家的商品");
            return null;
        }
    }
}
