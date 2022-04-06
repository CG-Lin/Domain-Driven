package com.domain.driven.domain;

import java.util.ArrayList;
import java.util.List;

public class DomainEventPublisher {
    private static final ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>() {
        @Override
        protected DomainEventPublisher initialValue() {
            return new DomainEventPublisher();
        }
    };

    //做一个判断是否正在发布
    private boolean publishing;

    //订阅方列表
    @SuppressWarnings("rawtypes")
    private List subscribers;


    public static DomainEventPublisher instance() {
        DomainEventPublisher domainEventPublisher = instance.get();
        return domainEventPublisher;
    }


    @SuppressWarnings("rawtypes")
    private List subscribers() {
        return this.subscribers;
    }

    //设置发布状态
    private void setPublishing(boolean flag) {
        this.publishing = flag;
    }

    @SuppressWarnings("rawtypes")
    private void setSubscribers(List subscriberList) {
        this.subscribers = subscriberList;
    }

    //查看当前是否有订阅集合
    @SuppressWarnings("rawtypes")
    public boolean hasSubscribers() {
        return subscribers() != null;
    }

    //如果当前订阅集合为空则创建一个新的集合
    @SuppressWarnings("rawtypes")
    private void ensureSubscribersList() {
        if (!this.hasSubscribers()) {
            this.setSubscribers(new ArrayList());
        }
    }

    //如果当前没有在进行发布，则进行订阅集合判断后将新的订阅者加入集合列表
    @SuppressWarnings("unchecked")
    public <T> void subscribe(DomainEventSubscriber<T> aSubscriber) {
        if (!this.publishing) {
            this.ensureSubscribersList();
            this.subscribers().add(aSubscriber);
        }
    }

    //此处的<T> 表示传入参数有泛型,<T>存在的作用，是为了保证参数中能够出现T这种数据类型
    public <T> void publish(T useDomainEvent) {
        //如果没有正在发布消息同时候订阅列表不为空
        if (!this.publishing && hasSubscribers()) {
            try {
                this.setPublishing(true);
                //获取当前正在发布消息的领域事件类名
                Class<?> publishClass = useDomainEvent.getClass();
                //获取当前所有订阅者
                List<DomainEventSubscriber<T>> allSubscribers = this.subscribers();
                //遍历所有订阅者列表
                for (DomainEventSubscriber<T> subscriber : allSubscribers) {
                    //返回对应的领域事件类
                    Class<T> subscribedToType = subscriber.subscribedToEventType();
                    //如果发布的领域事件类型与订阅列表的类型匹配上，则将事件交给对应的处理器进行处理
                    if (subscribedToType.toString().equals(publishClass.toString()) ) {
                        subscriber.handleEvent(useDomainEvent);
                    }
                }
            }finally {
                //处理完后告知发布消息事件已经结束
                this.setPublishing(false);
            }
        }
    }
}
