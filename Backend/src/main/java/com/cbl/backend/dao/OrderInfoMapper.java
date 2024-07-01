package com.cbl.backend.dao;

import com.cbl.backend.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrderInfoMapper {
    // 添加订单信息
    int addOrderInfo(OrderInfo orderInfo);
    //根据用户id查询订单信息
    List<OrderInfo> getOrderInfoByUserId(int userId);

}
