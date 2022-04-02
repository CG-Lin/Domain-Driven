package com.domain.driven.domain;

import lombok.Data;

import java.math.BigDecimal;

//补充上下文信息
@Data
public class OrderCreateEvent extends OrderDomain{
    //订单价格
    private BigDecimal price;

    //收获地址
    private String address;
}
