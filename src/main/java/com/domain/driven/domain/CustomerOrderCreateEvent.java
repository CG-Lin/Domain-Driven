package com.domain.driven.domain;

import lombok.Data;

//在订单创建时可以根据现实需求补充上下文信息
@Data
public class CustomerOrderCreateEvent extends OrderDomain{
    //基础订单信息
    private Order order;

    //面向客户的订单信息，额外添加收获地址
    private String address;

    public CustomerOrderCreateEvent(Order order,String address){
        this.address = address;
        this.order = order;
    }
}
