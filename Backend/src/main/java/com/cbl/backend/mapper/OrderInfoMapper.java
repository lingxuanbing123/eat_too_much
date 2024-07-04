package com.cbl.backend.mapper;

import com.cbl.backend.entity.OrderInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderInfoMapper {
    @Select("SELECT * FROM order_info WHERE userid = #{userid} ORDER BY id desc;")
    List<OrderInfo> getOrderInfoByUserId(@Param("userid") String userid);

    @Insert("INSERT INTO `order_info`(userid,goodId,goodNum,orderPrices,goodName) VALUES(#{userid},#{goodId},#{goodNum},#{orderPrices},#{goodName})")
    void add(OrderInfo orderInfo);

    @Delete("DELETE FROM order_info WHERE id = #{id}")
    void delete(@Param("id") int id);
}
