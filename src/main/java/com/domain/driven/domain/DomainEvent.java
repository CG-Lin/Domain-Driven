package com.domain.driven.domain;

import javax.xml.crypto.Data;
import java.util.Date;

//定义领域事件接口
public interface DomainEvent {
    String id();

    Date occurredOn();

    default Date getCreatEventTime(){
        return occurredOn();
    }

    default String type(){
        return getClass().getSimpleName();
    }

    default String getType(){
        return type();
    }
}
