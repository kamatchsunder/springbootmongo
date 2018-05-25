package com.sunder.mongospringbootexample.controller;

import com.sunder.mongospringbootexample.service.MyRepository;
import com.sunder.mongospringbootexample.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MongoController {


    private MyRepository myRepository;
    public MongoController(final MyRepository myRepository){
        this.myRepository = myRepository;
        initUserInformation();
    }


    @RequestMapping(value="/api/objects/{age}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsersByAge(@PathVariable(value = "age")  String age){

        return myRepository.findByAge(age);
    }


    public void initUserInformation(){

        myRepository.save(new User("sunder","30"));
        myRepository.save(new User("raj","30"));
        myRepository.save(new User("viv","30"));
        myRepository.save(new User("sah","20"));
        myRepository.save(new User("man","20"));
        myRepository.save(new User("jam","25"));
        myRepository.save(new User("gan","25"));
        myRepository.save(new User("vin","25"));
        myRepository.save(new User("siv","30"));
        myRepository.save(new User("upa","30"));
    }



}
