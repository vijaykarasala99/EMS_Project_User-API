package com.vijayit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeManagementUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementUserApplication.class, args);
	}

}
