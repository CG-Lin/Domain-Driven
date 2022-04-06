package com.domain.driven.domain;

import lombok.Data;

import java.util.Date;

@Data
public abstract class TicketDomain implements DomainEvent{
    //补充到聚合根信息中
    private String orderId;

    private Date occurredOn;

    @Override
    public String id() {
        return this.orderId;
    }

    @Override
    public Date occurredOn() {
        return this.occurredOn;
    }
}
