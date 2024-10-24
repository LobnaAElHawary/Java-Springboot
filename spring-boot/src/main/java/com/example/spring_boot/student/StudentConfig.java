package com.example.spring_boot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            Student Lobna = new Student(
              1L,
              "lobna",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "email"
            );
            Student Samer = new Student(
                    2L,
                    "samer",
                    LocalDate.of(2000, Month.JANUARY, 5),
                    "email"
            );

            // this saved 2 new rows in the student table
            repository.saveAll(List.of(Lobna, Samer));
        };
    }
}
