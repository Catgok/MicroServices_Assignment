package com.catgok.domain.Order.service;

import com.catgok.domain.Order.entity.Business;
import com.catgok.domain.Order.entity.Order;
import com.catgok.domain.Order.repository.OrderPo;
import com.catgok.domain.OrderDetail.service.OrderDetailDomainService;
import com.catgok.infrastructure.feign.business.BusinessFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFactory {
    @Autowired
    BusinessFeignService businessFeignService;

    @Autowired
    OrderDetailDomainService orderDetailDomainService;

    public OrderPo createOrderPO(Order order) {
        OrderPo orderPo = new OrderPo();
        if (null != order.getOrderId() && order.getOrderId() != 0) orderPo.setOrderId(order.getOrderId());
        orderPo.setUserId(order.getUserId());
        orderPo.setBusinessId(order.getBusinessId());
        orderPo.setOrderDate(order.getOrderDate());
        orderPo.setOrderTotal(order.getOrderTotal());
        orderPo.setDaId(order.getDaId());
        orderPo.setOrderState(order.getOrderState());
        return orderPo;
    }

    public Order createOrder(OrderPo orderPo) {
        Order order = new Order();
        order.setOrderId(orderPo.getOrderId());
        order.setUserId(orderPo.getUserId());
        order.setBusinessId(orderPo.getBusinessId());
        order.setOrderDate(orderPo.getOrderDate());
        order.setOrderTotal(orderPo.getOrderTotal());
        order.setDaId(orderPo.getDaId());
        order.setOrderState(orderPo.getOrderState());
        Business business = new Business();
        business.setBusinessId(orderPo.getBusinessId());
        order.setBusiness(businessFeignService.getBusinessById(business));
        order.setList(orderDetailDomainService.listOrderDetailByOrderId(orderPo.getOrderId()));
        return order;
    }
}
