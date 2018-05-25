package com.sunder.mongospringbootexample.model;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgeEvent {

    private String age;


    public AgeEvent(String age) {

        this.age = age;
    }


}
