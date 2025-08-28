package com.example.Back2U;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Back2UApplication {

	public static void main(String[] args) {
		SpringApplication.run(Back2UApplication.class, args);
	}

}
