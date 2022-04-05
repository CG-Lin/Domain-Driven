package com.domain.driven.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Order {
    private Long Id;
    //订单状态
    private Integer OrderState;
    //接单的饭店Id
    private Long restaurantId;
    //消费者Id
    private Long consumerId;
    //订单创建时间
    private LocalDateTime orderCreateTime;
    //修改订单
    private LocalDateTime orderChangeTime;
    //订单完成时间
    private LocalDateTime finishCreateTime;

}
