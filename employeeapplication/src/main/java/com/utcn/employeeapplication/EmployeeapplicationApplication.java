package com.utcn.employeeapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.utcn.employeeapplication.department")
public class EmployeeapplicationApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeapplicationApplication.class, args);
	}
}
