package com.guestbook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guestbook.repo.UserRepository;

@SpringBootApplication
public class GuestbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestbookApplication.class, args);

	}

	// @Bean
	public CommandLineRunner loadData(UserRepository repository) {
		return (args) -> {
			// save a couple of customers
			// repository.save(new User("admin", new
			// BCryptPasswordEncoder().encode("admin"), Boolean.TRUE, "ADMIN"));
		};
	}

}