package com.spring.boot.data.jpa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	@Value("${server.port}")
	private int serverPort;

	@GetMapping
	public String welcome(){
		return "Spring Boot Data JPA Application Running Well on Port " + serverPort;
	}
}
