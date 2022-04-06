package com.domain.driven.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Ticket {

    //所有价格
    private BigDecimal realAmount;
    //优惠
    private BigDecimal discounts;
    private Set<Order> orders;
    //订单创建时间
    private LocalDateTime orderCreateTime;
    //修改订单
    private LocalDateTime orderChangeTime;
    //订单完成时间
    private LocalDateTime finishCreateTime;

    //未优惠情况下应付应付总额
    public BigDecimal getAllAmount(){
        return orders.stream().map(Order::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    //价格优惠后实际应付总额
    public BigDecimal getRealAmount(){
        BigDecimal allAmount = getAllAmount();
        return allAmount.subtract(discounts);
    }

}
