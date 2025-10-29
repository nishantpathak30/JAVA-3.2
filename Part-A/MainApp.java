package com.example.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Create Spring container using Java-based config
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve bean
        Student student = context.getBean(Student.class);

        // Call method to verify injection
        student.displayInfo();
    }
}
