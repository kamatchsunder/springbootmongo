package com.sunder.mongospringbootexample.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


@Service
public class EventReceiver {


    public void receiveMessage(Object message) {

        try {
            System.out.println("Received <" + new ObjectMapper().writeValueAsString(message) + ">");
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
