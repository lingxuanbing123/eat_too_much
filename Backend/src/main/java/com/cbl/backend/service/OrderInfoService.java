package com.cbl.backend.service;

import com.cbl.backend.dao.OrderInfoMapper;
import com.cbl.backend.entity.OrderInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderInfoService {
    @Resource
    OrderInfoMapper orderInfoMapper;
    //添加订单信息
    public int addOrderInfo(OrderInfo orderInfo)
    {
        return orderInfoMapper.addOrderInfo(orderInfo);
    }
    //根据用户id获取订单信息
    public List<OrderInfo> getOrderInfoByUserId(int userId)
    {
        return orderInfoMapper.getOrderInfoByUserId(userId);
    }
}
