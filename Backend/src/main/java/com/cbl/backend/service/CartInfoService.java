package com.cbl.backend.service;

import com.cbl.backend.dao.CartInfoMapper;
import com.cbl.backend.entity.CartInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartInfoService {
    @Resource
    CartInfoMapper cartInfoMapper;

    // 添加购物车信息
    public int addCartInfo(CartInfo cartInfo) {
        return cartInfoMapper.addCartInfo(cartInfo);
    }

    // 根据用户id删除购物车信息
    public int deleteCartInfoByUserAndGoodId(String userId, int goodId) {
        return cartInfoMapper.deleteCartInfoByUserAndGoodId(userId, goodId);
    }

    // 根据用户id获取购物车信息
    public List<CartInfo> getCartInfoByUserId(String userId) {
        return cartInfoMapper.getCartInfoByUserId(userId);
    }
}
