package com.domain.driven;

import com.domain.driven.domain.*;
import com.domain.driven.message.DomainEventPublisher;
import com.domain.driven.message.DomainEventSubscriber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrivenApplicationTests {

    @Test
    void contextLoads() {
        DomainEventPublisher.instance().subscribe(new DomainEventSubscriber<CustomerTicketCreateEvent>() {


            @Override
            public void handleEvent(CustomerTicketCreateEvent aDomainEvent) {
                System.out.println("hello world");
            }

            @Override
            public Class<CustomerTicketCreateEvent> subscribedToEventType() {
                return CustomerTicketCreateEvent.class;
            }
        });

        Order order = new Order();
        String address = "M78星云光之国成化大道消防队对面";

        DomainEventPublisher.instance().publish(new CustomerTicketCreateEvent(order,address));
    }

}
