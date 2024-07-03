package com.cbl.backend.controller;

import com.cbl.backend.entity.OrderInfo;
import com.cbl.backend.mapper.OrderInfoMapper;
import com.cbl.backend.utils.NewResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static java.sql.DriverManager.println;

@RestController
public class OrderInfoController {
    @Resource
    OrderInfoMapper orderInfoMapper;

    @GetMapping("/orderInfo/select")
    public List<OrderInfo> getOrderInfoByUserId(@RequestBody String userId){
        if(orderInfoMapper.getOrderInfoByUserId(userId) != null){
            System.out.println(orderInfoMapper.getOrderInfoByUserId(userId));
            return orderInfoMapper.getOrderInfoByUserId(userId);
        }
        else{
            println("用户订单不存在");
            return null;
        }
    }

    @PostMapping("/orderInfo/add")
    public ResponseEntity<Void> addOrderInfo(@RequestBody OrderInfo orderInfo){
        try {
            orderInfoMapper.addOrderInfo(orderInfo);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
