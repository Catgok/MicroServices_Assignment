package com.catgok.domain.Order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<OrderPo, Integer> {
    public OrderPo getOrderPoByOrderId(Integer oid);

    public List<OrderPo> getOrderPosByUserId(String userId);
}
