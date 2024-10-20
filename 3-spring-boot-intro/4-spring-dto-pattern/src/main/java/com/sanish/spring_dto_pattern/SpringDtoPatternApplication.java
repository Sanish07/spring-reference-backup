package com.sanish.spring_dto_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDtoPatternApplication {

	public static void main(String[] args) {
		//To see how DTOs work see the organization and employee controllers post, get(All type) methods.
		ApplicationContext context = SpringApplication.run(SpringDtoPatternApplication.class, args);
	}

}
