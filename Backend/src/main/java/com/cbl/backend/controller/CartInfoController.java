package com.cbl.backend.controller;

import com.cbl.backend.entity.CartInfo;
import com.cbl.backend.service.CartInfoService;
import com.cbl.backend.utils.NewResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags="购物车信息接口", value = "CartInfoController")
@RestController
@RequestMapping("/api/cartInfo")
public class CartInfoController {
    @Autowired
    private CartInfoService cartInfoService;
    @ApiOperation(value = "添加购物车信息", notes = "添加购物车信息")
    @PostMapping("/addCartInfo")
    public NewResult addCartInfo(CartInfo cartInfo) {
        int i = cartInfoService.addCartInfo(cartInfo);
        if (i == 1) {
            return NewResult.success();
        } else {
            return NewResult.error("添加失败");
        }
    }
    @ApiOperation(value = "根据用户id获取购物车信息", notes = "根据用户id获取购物车信息")
    @PostMapping("/getCartInfoByUserId")
    public List<CartInfo> getCartInfoByUserId(String userId) {
        return cartInfoService.getCartInfoByUserId(userId);
    }
    @ApiOperation(value = "根据用户id和商品id删除购物车信息", notes = "根据用户id和商品id删除购物车信息")
    @PostMapping("/deleteCartInfoByUserAndGoodId")
    public NewResult deleteCartInfoByUserAndGoodId(String userId, int goodId) {
        int i = cartInfoService.deleteCartInfoByUserAndGoodId(userId, goodId);
        if (i == 1) {
            return NewResult.success();
        } else {
            return NewResult.error("删除失败");
        }
    }
}
