package com.catgok.application.service.impl;

import com.catgok.application.service.OrderService;
import com.catgok.domain.Order.entity.Order;
import com.catgok.domain.Order.service.OrderDomainService;
import com.catgok.domain.OrderDetail.service.OrderDetailDomainService;
import com.catgok.infrastructure.feign.cart.CartFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDomainService orderDomainService;
    @Autowired
    OrderDetailDomainService orderDetailDomainService;
    @Autowired
    CartFeignService cartFeignService;

    @Override
    public int createOrder(Order order) {
        // 创建订单
        order.setOrderState(0);
        int orderId = orderDomainService.saveOrder(order);
        order.setOrderId(orderId);
        // 添加订单明细
        orderDetailDomainService.saveOrderDetailBatch(order);
        // 删除购物车中信息
        cartFeignService.removeCartByUserIdAndBusinessId(order.getUserId(), order.getBusinessId());
        return orderId;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderDomainService.getOrderById(orderId);
    }

    @Override
    public List<Order> listOrdersByUserId(String userId) {
        return orderDomainService.listOrdersByUserId(userId);
    }
}
