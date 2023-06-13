package com.catgok.interfaces;

import com.catgok.application.service.OrderService;
import com.catgok.domain.Order.entity.Order;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/OrdersController")
public class OrderInterface {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrders")
    public int createOrders(Order orders) throws Exception {
        return orderService.createOrder(orders);
    }

    @RequestMapping("/getOrdersById")
    @RateLimiter(name = "limiterA", fallbackMethod = "getOrderFallBack")
    public Order getOrdersById(@RequestBody Order order) throws Exception {
        return orderService.getOrderById(order.getOrderId());
    }

    public Order getOrderFallBack(@RequestBody Order order, Throwable e) {
        order.setOrderId(-1);
        return order;
    }

    @RequestMapping("/listOrdersByUserId")
    public List<Order> listOrdersByUserId(Order orders) throws Exception {
        return orderService.listOrdersByUserId(orders.getUserId());
    }
}
