package com.catgok.domain.OrderDetail.service;

import com.catgok.domain.OrderDetail.entity.OrderDetail;
import com.catgok.domain.OrderDetail.repository.OrderDetailPo;
import com.catgok.infrastructure.feign.business.BusinessFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailFactory {
    @Autowired
    BusinessFeignService businessFeignService;

    public OrderDetailPo createOrderDetailPo(OrderDetail orderDetail) {
        OrderDetailPo orderDetailPo = new OrderDetailPo();
        orderDetailPo.setOdId(orderDetail.getOdId());
        orderDetailPo.setOrderId(orderDetail.getOrderId());
        orderDetailPo.setFoodId(orderDetail.getFoodId());
        orderDetailPo.setQuantity(orderDetail.getQuantity());
        return orderDetailPo;
    }

    public OrderDetail createOrderDetail(OrderDetailPo orderDetailPo) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOdId(orderDetailPo.getOdId());
        orderDetail.setOrderId(orderDetailPo.getOrderId());
        orderDetail.setFoodId(orderDetailPo.getFoodId());
        orderDetail.setQuantity(orderDetailPo.getQuantity());
        orderDetail.setFood(businessFeignService.getFoodById(orderDetailPo.getFoodId()));
        return orderDetail;
    }
}
