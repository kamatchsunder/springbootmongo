package com.sunder.mongospringbootexample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class User {

    @Id
    public String id;

    public String name;
    public String age;


    public User(String name, String age) {

        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {

        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
