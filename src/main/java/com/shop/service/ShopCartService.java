package com.shop.service;


import com.shop.entity.ShopCart;
import com.shop.entity.ShopCartExample;
import com.shop.entity.ShopCartKey;

import java.util.List;

public interface ShopCartService {
    public void addShopCart(ShopCart shopCart);

    public List<ShopCart> selectByExample(ShopCartExample shopCartExample);

    public void deleteByKey(ShopCartKey shopCartKey);

    public void updateCartByKey(ShopCart shopCart);

    public ShopCart selectCartByKey(ShopCartKey shopCartKey);
}
