package com.domain.driven;

import com.domain.driven.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrivenApplicationTests {

    @Test
    void contextLoads() {
        DomainEventPublisher.instance().subscribe(new DomainEventSubscriber<OrderCreateEvent>() {


            @Override
            public void handleEvent(OrderCreateEvent aDomainEvent) {
                System.out.println("hello world");
            }

            @Override
            public Class<OrderCreateEvent> subscribedToEventType() {
                return OrderCreateEvent.class;
            }
        });

        DomainEventPublisher.instance().publish(new OrderCreateEvent());
    }

}
