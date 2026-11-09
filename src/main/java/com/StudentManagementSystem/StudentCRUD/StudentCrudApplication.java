package com.StudentManagementSystem.StudentCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.StudentManagementSystem")
@EntityScan(basePackages = "com.StudentManagementSystem.model")
@EnableJpaRepositories(basePackages = "com.StudentManagementSystem.repository")
public class StudentCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentCrudApplication.class, args);
    }
}