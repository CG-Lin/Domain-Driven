package com.domain.driven.domain;

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
        return instance.get();
    }


    @SuppressWarnings("rawtypes")
    private List subscribers() {
        return this.subscribers;
    }

    @SuppressWarnings("rawtypes")
    public boolean hasSubscribers() {
        return subscribers() != null;
    }
    //设置发布状态
    private void setPublishing(boolean flag) {
        this.publishing = flag;
    }

    //此处的<T> 表示传入参数有泛型,<T>存在的作用，是为了保证参数中能够出现T这种数据类型
    public <T> void publish(T useDomainEvent) {
        //如果没有正在发布消息同时候订阅列表不为空
        if (!this.publishing && hasSubscribers()) {
            try {
                this.setPublishing(true);

                Class<?> publishClass = useDomainEvent.getClass();

                List<DomainEventSubscriber<T>> allSubscribers = this.subscribers();

                //遍历所有订阅列表
                for (DomainEventSubscriber<T> subscriber : allSubscribers) {
                    Class<T> subscribedToType = subscriber.subscribedToEventType();
                    //如果发布的领域事件类型与订阅列表的类型匹配上，则将事件进行处理
                    if (publishClass == subscribedToType || subscribedToType == DomainEvent.class) {
                        subscriber.handleEvent(useDomainEvent);
                    }
                }
            }finally {
                //处理完后告知发布消息事件已经结束
                this.setPublishing(false);
            }
        }
    }




    //
}
