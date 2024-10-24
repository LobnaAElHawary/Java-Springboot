package com.example.spring_boot;

import com.example.spring_boot.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
//@RestController //makes the class to serve rest endpoints
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// This is where we would go if we went to localhost:8080
//	@GetMapping
//	public String hello() {
//		return "Hello World";
//	}
}
