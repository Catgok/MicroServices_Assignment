package com.catgok.domain.OrderDetail.entity;

import lombok.Data;

@Data
public class OrderDetail {
    private Integer odId;
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;
    //多对一：所属食品
    private Food food;
}
