package com.cbl.backend.mapper;

import com.cbl.backend.entity.CartInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartInfoMapper {
    @Select("SELECT * FROM `cart_info` WHERE userid = #{userId} ORDER BY id desc")
    List<CartInfo> getCartInfoByUserId(@Param("userId") String userId);

    @Insert("INSERT INTO `cart_info`(userid,goodId,goodName,goodPrice,goodNum,businessId) VALUES(#{userId},#{goodId},#{goodName},#{goodPrice},#{goodNum},#{businessId})")
    void addCartInfo(CartInfo cartInfo);

    @Delete("DELETE FROM `cart_info` WHERE userid = #{userId} AND goodId = #{goodId}")
    void deleteCartInfoByUserAndGoodId(@Param("userId") String userId, @Param("goodId") int goodId);
}
