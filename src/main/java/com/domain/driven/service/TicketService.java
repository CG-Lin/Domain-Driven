package com.domain.driven.service;

import com.domain.driven.domain.CustomerTicketCreateEvent;
import com.domain.driven.message.DomainEventPublisher;
import com.domain.driven.message.DomainEventSubscriber;

public class TicketService {
    public void saveTicket(){
        DomainEventPublisher.instance().subscribe(new DomainEventSubscriber<CustomerTicketCreateEvent>() {

            @Override
            public void handleEvent(CustomerTicketCreateEvent domainEvent) {
                System.out.println("收货地址是:"+ domainEvent.getAddress());

                System.out.println("goods was purchased");
                //将顶到保存到数据库,可以增加与db数据库的增删查改操作
                System.out.println("db has save!!");
            }

            @Override
            public Class<CustomerTicketCreateEvent> subscribedToEventType() {
                return CustomerTicketCreateEvent.class;
            }
        });
    }
}
