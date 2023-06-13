package com.catgok.domain.OrderDetail.repository;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orderdetail")
public class OrderDetailPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer odId;
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;
}