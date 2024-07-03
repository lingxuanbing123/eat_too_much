package com.cbl.backend.mapper;

import com.cbl.backend.entity.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderInfoMapper {
    @Select("SELECT * FROM order_info WHERE userid = #{userId} ORDER BY id desc;")
    List<OrderInfo> getOrderInfoByUserId(@Param("userId") String userId);

    @Insert("INSERT INTO `order_info`(userid,goodId,goodNum,goodPrice,isPay,goodName) VALUES(#{userId},#{goodId},#{goodNum},#{goodPrice},#{isPay},#{goodName})")
    void addOrderInfo(OrderInfo orderInfo);
}
