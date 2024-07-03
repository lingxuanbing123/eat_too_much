package com.cbl.backend.controller;

import com.cbl.backend.entity.OrderInfo;
import com.cbl.backend.entity.User;
import com.cbl.backend.mapper.OrderInfoMapper;
import com.cbl.backend.utils.NewResult;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.sql.DriverManager.println;

@RestController
public class OrderInfoController {
    @Resource
    OrderInfoMapper orderInfoMapper;

    @GetMapping("/orderInfo/info")
    public List<OrderInfo> list(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(orderInfoMapper.getOrderInfoByUserId(user.getUserid()) != null){
            System.out.println(orderInfoMapper.getOrderInfoByUserId(user.getUserid()));
            return orderInfoMapper.getOrderInfoByUserId(user.getUserid());
        }
        else{
            println("用户订单不存在");
            return null;
        }
    }

    @PostMapping("/orderInfo/add")
    public ResponseEntity<Void> addOrderInfo(@RequestBody OrderInfo orderInfo){
        try {
            orderInfoMapper.add(orderInfo);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/orderInfo/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        try {
            orderInfoMapper.delete(id);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
