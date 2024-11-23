package com.sanish.custom_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CustomAuthApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CustomAuthApplication.class, args);
	}

}
