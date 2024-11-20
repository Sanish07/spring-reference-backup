package com.sanish.managing_users;

import com.sanish.managing_users.entity.User;
import com.sanish.managing_users.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ManagingUsersApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ManagingUsersApplication.class, args);
	}

//	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository){
		return args ->{
			User new_user = User.builder()
					.username("sanish")
					.password("123")
					.build();

			userRepository.save(new_user);
		};
	}

}
