package com.domain.driven.domain;

import lombok.Data;

//在订单创建时可以根据现实需求补充上下文信息,如果没有为空就可以
@Data
public class CustomerTicketCreateEvent extends TicketDomain {
    //基础订单信息
    private Ticket ticket;

    //面向客户的订单信息，额外添加收获地址
    private String address;

    public CustomerTicketCreateEvent(Ticket ticket, String address){
        this.address = address;
        this.ticket = ticket;
    }

}
