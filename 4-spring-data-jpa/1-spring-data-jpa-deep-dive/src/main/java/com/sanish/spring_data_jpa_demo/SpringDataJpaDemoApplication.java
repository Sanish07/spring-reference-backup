package com.sanish.spring_data_jpa_demo;

import com.github.javafaker.Faker;
import com.sanish.spring_data_jpa_demo.entities.Author;
import com.sanish.spring_data_jpa_demo.entities.resource_types.Text;
import com.sanish.spring_data_jpa_demo.repositories.AuthorRepository;
import com.sanish.spring_data_jpa_demo.repositories.TextRepository;
import com.sanish.spring_data_jpa_demo.specifications.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
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



			//Update the author with id 1 by passing the id - ID should exist or a new entry will be created
			/*var update_author = Author.builder()
					.id(1)
					.firstName("Leo")
					.lastName("Messi")
					.age(37)
					.email("leomessi@afa.com")
					.build();

			authorRepository.save(update_author); */

			//Testing the derived query from AuthorRepository
			/*List<Author> f1 = authorRepository.findAllByFirstNameIgnoreCase("leo");

			for(Author author : f1){
				System.out.println(author);
			}*/



			//Testing custom update query in AuthorRepository
			//Setting age = 45 of author with id 20.
			/*Integer res = authorRepository.updateAuthorAge(45,20);
			System.out.println(res);*/

			//Testing another custom query method
			//Changing all authors last_modified_at time to current time
			/*authorRepository.updateAllAuthorLastModifiedTime(LocalDateTime.now());*/




			//Testing select named query defined in Author entity and repository
			/*List<Author> authors = authorRepository.namedQueryFindByAge(45);
			authors.forEach(System.out::println);*/

			//Testing update named query
			/*authorRepository.namedQuerySetAllModTime(LocalDateTime.now());*/


			//Testing the specification with multiple predicates with
			// 'and' clause - can omit it or replace it with 'or' or other clauses
			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(45))
					.and(AuthorSpecification.firstNameLike("Tr"));

			List<Author> authors = authorRepository.findAll(spec);
			authors.forEach(System.out::println);



			//Testing inheritance class
			/*var text_obj = Text.builder()
					.name("imp_file")
					.size(10)
					.text_content("Saved passwords here.")
					.build();
			textRepository.save(text_obj);*/


		};
	}

}
