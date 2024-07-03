package com.cbl.backend.controller;

import com.cbl.backend.entity.Good;
import com.cbl.backend.mapper.GoodMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static java.sql.DriverManager.println;

@RestController
public class GoodControl {
    @Resource
    GoodMapper goodMapper;

    @GetMapping("/good/select")
    public List<Good> getGoodByBusinessId(@RequestBody String businessId){
        if(goodMapper.getGoodByBusinessId(businessId) != null){
            System.out.println(goodMapper.getGoodByBusinessId(businessId));
            return goodMapper.getGoodByBusinessId(businessId);
        }
        else{
            println("没有该商家的商品");
            return null;
        }
    }

    @PostMapping("/good/add")
    public ResponseEntity<Void> addGood(@RequestBody Good good){
        try {
            goodMapper.addGood(good);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/good/delete")
    public ResponseEntity<Void> deleteGoodByGoodId(@RequestBody int goodId){
        try {
            goodMapper.deleteGoodByGoodId(goodId);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
