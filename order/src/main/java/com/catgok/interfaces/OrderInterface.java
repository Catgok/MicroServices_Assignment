package com.catgok.interfaces;

import com.catgok.application.service.OrderService;
import com.catgok.domain.Order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrdersController")
public class OrderInterface {
    @Autowired
    private OrderService orderService;

    @GetMapping("/ping")
    public String ping() {
        return "order";
    }

    @RequestMapping("/createOrders")
    public int createOrders(Order orders) throws Exception {
        return orderService.createOrder(orders);
    }

    @RequestMapping("/getOrdersById")
    public Order getOrdersById(@RequestBody Order order) throws Exception {
        return orderService.getOrderById(order.getOrderId());
    }

    @RequestMapping("/listOrdersByUserId")
    public List<Order> listOrdersByUserId(Order orders) throws Exception {
        return orderService.listOrdersByUserId(orders.getUserId());
    }
}
