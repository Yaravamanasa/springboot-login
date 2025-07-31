package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
	 @Bean
	    public CommandLineRunner dataLoader(UserRepository repo) {
	        return args -> {
	            User user = new User();
	            user.setUsername("manasa");
	            user.setPassword("1234");
	            repo.save(user);
	        };

}
}
