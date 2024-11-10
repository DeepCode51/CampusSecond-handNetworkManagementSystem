package com.shop.service.impl;


import com.shop.dao.ShopCartMapper;
import com.shop.entity.ShopCart;
import com.shop.entity.ShopCartExample;
import com.shop.entity.ShopCartKey;
import com.shop.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addShopCart")
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired(required = false)
    ShopCartMapper shopCartMapper;

    @Override
    public void addShopCart(ShopCart shopCart) {
        shopCartMapper.insertSelective(shopCart);
    }

    @Override
    public List<ShopCart> selectByExample(ShopCartExample shopCartExample) {
        return shopCartMapper.selectByExample(shopCartExample);
    }

    @Override
    public void deleteByKey(ShopCartKey shopCartKey) {
        shopCartMapper.deleteByPrimaryKey(shopCartKey);
    }

    @Override
    public void updateCartByKey(ShopCart shopCart) {
        shopCartMapper.updateByPrimaryKeySelective(shopCart);
    }

    @Override
    public ShopCart selectCartByKey(ShopCartKey shopCartKey) {
        return shopCartMapper.selectByPrimaryKey(shopCartKey);
    }
}
