package com.sanish.spring_data_jpa_demo;

import com.sanish.spring_data_jpa_demo.entities.Author;
import com.sanish.spring_data_jpa_demo.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner( //Using CommandLineRunner Bean we can perform CRUD operation without the need of controller.
			AuthorRepository authorRepository
	){
		return args -> {
			var author = Author.builder()
					.firstName("Roberto")
					.lastName("Carlos")
					.age(55)
					.email("carlos@gmail.com")
					.build();

			authorRepository.save(author);
		};
	}

}
