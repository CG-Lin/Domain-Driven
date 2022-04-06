package com.domain.driven;

import com.domain.driven.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrivenApplicationTests {

    @Test
    void contextLoads() {
        DomainEventPublisher.instance().subscribe(new DomainEventSubscriber<CustomerOrderCreateEvent>() {


            @Override
            public void handleEvent(CustomerOrderCreateEvent aDomainEvent) {
                System.out.println("hello world");
            }

            @Override
            public Class<CustomerOrderCreateEvent> subscribedToEventType() {
                return CustomerOrderCreateEvent.class;
            }
        });

        Order order = new Order();
        String address = "M78星云光之国成化大道消防队对面";

        DomainEventPublisher.instance().publish(new CustomerOrderCreateEvent(order,address));
    }

}
