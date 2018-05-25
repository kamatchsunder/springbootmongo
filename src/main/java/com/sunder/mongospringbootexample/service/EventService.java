package com.sunder.mongospringbootexample.service;

import com.sunder.mongospringbootexample.model.AgeEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class EventService {

    @Autowired
    private RabbitTemplate eventTemplate;

    @Scheduled(fixedDelay = 10000)
    public void scheduleEvent(){

        AgeEvent ageEvent = new AgeEvent("30");

        eventTemplate.convertAndSend(ageEvent);

    }
}
