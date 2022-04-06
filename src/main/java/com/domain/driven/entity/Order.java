package com.domain.driven.entity;

import lombok.Data;

import java.math.BigDecimal;

//单个商品的订单信息
@Data
public class Order {
    private Long Id;
    //订单状态
    private Integer OrderState;
    //用户Id
    private Integer userId;
    //单个订单价格
    private BigDecimal price;
    //接单的饭店Id
    private Long restaurantId;
    //消费者Id
    private Long consumerId;
}
