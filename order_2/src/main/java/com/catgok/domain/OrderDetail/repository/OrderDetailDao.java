package com.catgok.domain.OrderDetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailDao extends JpaRepository<OrderDetailPo, Integer> {
    public List<OrderDetailPo> getOrderDetailPoByOrderId(Integer oid);
}
