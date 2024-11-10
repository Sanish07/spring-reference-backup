package com.sanish.spring_data_jpa_demo;

import com.github.javafaker.Faker;
import com.sanish.spring_data_jpa_demo.entities.Author;
import com.sanish.spring_data_jpa_demo.entities.resource_types.Text;
import com.sanish.spring_data_jpa_demo.repositories.AuthorRepository;
import com.sanish.spring_data_jpa_demo.repositories.TextRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner( //Using CommandLineRunner Bean we can perform CRUD operation without the need of controller.
			AuthorRepository authorRepository,
			TextRepository textRepository
	){
		return args -> {

			//Code to insert fake data in a table
			/*for(int i=0 ; i<50 ; i++){
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(20,60))
						.email(faker.internet().emailAddress())
						.build();

				authorRepository.save(author);
			}*/

			List<Author> f1 = authorRepository.findAllByFirstName("Rob");

			for(Author author : f1){
				System.out.println(author);
			}

			/* var author = Author.builder()
					.firstName("Roberto")
					.lastName("Carlos")
					.email("carlos@gmail.com")
					.build();

			authorRepository.save(author); */

			/*var text_obj = Text.builder()
					.name("imp_file")
					.size(10)
					.text_content("Saved passwords here.")
					.build();
			textRepository.save(text_obj);*/


		};
	}

}
