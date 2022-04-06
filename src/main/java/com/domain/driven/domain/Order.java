package com.domain.driven.domain;

import lombok.Data;

import java.math.BigDecimal;


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
