package com.domain.driven.domain;

public interface DomainEventSubscriber<T> {

    void handleEvent(final T aDomainEvent);

    Class<T> subscribedToEventType();
}
