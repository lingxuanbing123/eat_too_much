package com.cbl.backend.mapper;

import com.cbl.backend.entity.CartInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartInfoMapper {
    @Select("SELECT * FROM `cart_info` WHERE userid = #{userid} ORDER BY id desc")
    List<CartInfo> getCartInfoByUserId(@Param("userid") String userid);

    @Insert("INSERT INTO `cart_info`(userid,goodId,goodName,goodPrice,goodNum,businessId) VALUES(#{userid},#{goodId},#{goodName},#{goodPrice},#{goodNum},#{businessId})")
    void add(CartInfo cartInfo);

    @Delete("DELETE FROM `cart_info` WHERE id = #{id} ")
    void delete(@Param("id") int id);
}
