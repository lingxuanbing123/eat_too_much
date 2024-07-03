package com.cbl.backend.controller;

import com.cbl.backend.entity.CartInfo;
import com.cbl.backend.mapper.CartInfoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static java.sql.DriverManager.println;

@RestController
public class CartInfoController {
    @Resource
    CartInfoMapper cartInfoMapper;

    @GetMapping("/cartInfo/select")
    public List<CartInfo> GetCartInfoByUserId(@RequestBody String userId){
        if (cartInfoMapper.getCartInfoByUserId(userId) != null){
            System.out.println(cartInfoMapper.getCartInfoByUserId(userId));
            return cartInfoMapper.getCartInfoByUserId(userId);
        }
        else {
            println("该用户无购物车信息");
            return null;
        }
    }

    @PostMapping("/cartInfo/add")
    public ResponseEntity<Void> addCartInfo(@RequestBody CartInfo cartInfo){
        try {
            cartInfoMapper.addCartInfo(cartInfo);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/cartInfo/delete")
    public ResponseEntity<Void> deleteCartInfoByUserAndGoodId(@RequestBody String userId, @RequestBody int goodId ){
        try{
            cartInfoMapper.deleteCartInfoByUserAndGoodId(userId, goodId);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
