package com.example.springdemo;

public class Student {
    private Course course;  // dependency

    // Constructor injection
    public Student(Course course) {
        this.course = course;
    }

    public void displayInfo() {
        System.out.println("Student object created successfully!");
        course.showCourse();
    }
}
