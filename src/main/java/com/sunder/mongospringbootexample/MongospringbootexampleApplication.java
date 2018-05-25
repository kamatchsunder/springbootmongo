package com.sunder.mongospringbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan(value={"com.sunder.mongospringbootexample"})
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class MongospringbootexampleApplication extends SpringApplication{





	public static void main(String[] args) {
		SpringApplication.run(MongospringbootexampleApplication.class, args);
	}
}
