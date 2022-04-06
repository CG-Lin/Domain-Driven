package com.domain.driven.service;

import com.domain.driven.domain.CustomerTicketCreateEvent;
import com.domain.driven.domain.Ticket;
import com.domain.driven.message.DomainEventPublisher;
import com.domain.driven.message.DomainEventSubscriber;

//类似Service
//我们在这里做一个业务假设，例如预约购买，一旦某件商品上线，就通知我们自动创建订单进行支付
public class BuyService {
    //预定服务，定时任务到了，我发布创建订单的事件
    public void reservation(){
        Ticket ticket = new Ticket();
        String address = "M78星云光之国成化大道消防队对面";
        DomainEventPublisher.instance().publish(new CustomerTicketCreateEvent(ticket,address));
    }
}
