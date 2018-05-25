package com.sunder.mongospringbootexample.service;

import com.sunder.mongospringbootexample.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface MyRepository extends MongoRepository<User,String> {

   User findByName(String firstName);
   List<User> findByAge(String age);

}
