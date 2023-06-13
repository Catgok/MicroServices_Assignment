package com.catgok.domain.Order.service;

import com.catgok.domain.Order.entity.Order;
import com.catgok.domain.Order.repository.OrderDao;
import com.catgok.domain.Order.repository.OrderPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDomainService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderFactory orderFactory;

    public int saveOrder(Order order) {
        try {
            order.setOrderState(0);
            OrderPo o = orderDao.save(orderFactory.createOrderPO(order));
            return o.getOrderId();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Order getOrderById(Integer orderId) {
        return orderFactory.createOrder(orderDao.getOrderPoByOrderId(orderId));
    }

    public List<Order> listOrdersByUserId(String userId) {
        List<OrderPo> orderPos = orderDao.getOrderPosByUserId(userId);
        List<Order> orders = new ArrayList<>();
        for (OrderPo orderPo : orderPos) orders.add(orderFactory.createOrder(orderPo));
        return orders;
    }
}
