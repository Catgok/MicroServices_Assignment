package com.catgok.application.service;

import com.catgok.domain.Order.entity.Order;

import java.util.List;

public interface OrderService {
    int createOrder(Order orders);

    Order getOrderById(Integer orderId);

    List<Order> listOrdersByUserId(String userId);
}
