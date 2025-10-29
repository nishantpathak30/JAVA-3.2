package com.example.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Marks this class as a configuration class
public class AppConfig {

    @Bean  // Defines a bean for Course
    public Course courseBean() {
        return new Course("Data Structures and Algorithms");
    }

    @Bean  // Defines a bean for Student and injects Course
    public Student studentBean() {
        return new Student(courseBean());
    }
}
