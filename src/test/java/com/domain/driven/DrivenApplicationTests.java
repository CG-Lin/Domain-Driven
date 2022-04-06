package com.domain.driven;

import com.domain.driven.service.BuyService;
import com.domain.driven.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrivenApplicationTests {

    @Test
    void contextLoads() {
        TicketService ticketService = new TicketService();
        ticketService.saveTicket();

        BuyService buyService = new BuyService();
        buyService.reservation();
    }

}
