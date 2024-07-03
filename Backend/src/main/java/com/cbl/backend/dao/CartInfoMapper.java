package com.cbl.backend.dao;

import com.cbl.backend.entity.CartInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartInfoMapper {
    //添加购物车信息
    int addCartInfo(CartInfo cartInfo);
    //根据用户id删除购物车信息
    int deleteCartInfoByUserAndGoodId(String userId, int goodId);
    //根据用户id获取购物车信息
    List<CartInfo> getCartInfoByUserId(String userId);
}
