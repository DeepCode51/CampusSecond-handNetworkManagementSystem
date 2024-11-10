package com.shop.service;



import com.shop.entity.*;
import com.shop.entity.*;

import java.util.List;


public interface OrderService {
    public void insertOrder(Order order);

    public void deleteById(Integer orderid);


    public List<Order> selectOrderByExample(OrderExample orderExample);

    public List<OrderItem> getOrderItemByExample(OrderItemExample orderItemExample);

    public Address getAddressByKey(Integer addressid);

    public void updateOrderByKey(Order order);

    public Order selectByPrimaryKey(Integer orderid);

    void insertOrderItem(OrderItem orderItem);
}
