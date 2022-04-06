package com.domain.driven.service;

import com.domain.driven.domain.Order;

import java.util.Set;

public interface TicketService {
    public void CreateTicket(Set<Order> ticket);
}