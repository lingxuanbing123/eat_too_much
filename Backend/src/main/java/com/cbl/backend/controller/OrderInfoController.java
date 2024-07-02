package com.cbl.backend.controller;

import com.cbl.backend.entity.OrderInfo;
import com.cbl.backend.service.OrderInfoService;
import com.cbl.backend.utils.NewResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "订单信息接口", value = "OrderInfoController")
@RestController
@RequestMapping("/api/orderInfo")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation(value = "添加订单信息", notes = "添加订单信息")
    @PostMapping("/addOrderInfo")
    public NewResult addOrderInfo(@RequestBody OrderInfo orderInfo) {
        int i = orderInfoService.addOrderInfo(orderInfo);
        if (i > 0) {
            return NewResult.success();
        } else {
            return NewResult.error("添加失败");
        }
    }

    @ApiOperation(value = "根据用户id获取订单信息", notes = "根据用户id获取订单信息")
    @PostMapping("/getOrderInfoByUserId")
    public List<OrderInfo> getOrderInfoByUserId(@RequestBody String userId) {
        return orderInfoService.getOrderInfoByUserId(userId);
    }

}
