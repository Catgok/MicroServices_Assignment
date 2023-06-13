package com.catgok.domain.OrderDetail.service;

import com.catgok.domain.Order.entity.Cart;
import com.catgok.domain.Order.entity.Order;
import com.catgok.domain.OrderDetail.entity.OrderDetail;
import com.catgok.domain.OrderDetail.repository.OrderDetailDao;
import com.catgok.domain.OrderDetail.repository.OrderDetailPo;
import com.catgok.infrastructure.feign.cart.CartFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailDomainService {
    @Autowired
    OrderDetailDao orderDetailDao;

    @Autowired
    OrderDetailFactory orderDetailFactory;

    @Autowired
    CartFeignService cartfeignservice;

    public int saveOrderDetailBatch(Order order) {
        try {
            List<OrderDetail> orderDetails = new ArrayList<>();
            Cart cart = new Cart();
            cart.setUserId(order.getUserId());
            cart.setBusinessId(order.getBusinessId());
            List<Cart> cartList = cartfeignservice.listCart(cart);
            for (Cart c : cartList) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(order.getOrderId());
                orderDetail.setFoodId(c.getFoodId());
                orderDetail.setQuantity(c.getQuantity());
                orderDetails.add(orderDetail);
            }
            List<OrderDetailPo> orderDetailPos = new ArrayList<>();
            for (OrderDetail orderDetail : orderDetails)
                orderDetailPos.add(orderDetailFactory.createOrderDetailPo(orderDetail));
            orderDetailDao.saveAll(orderDetailPos);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<OrderDetail> listOrderDetailByOrderId(Integer orderId) {
        List<OrderDetailPo> orderDetailPos = orderDetailDao.getOrderDetailPoByOrderId(orderId);
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailPo orderDetailPo : orderDetailPos)
            orderDetails.add(orderDetailFactory.createOrderDetail(orderDetailPo));
        return orderDetails;
    }
}
