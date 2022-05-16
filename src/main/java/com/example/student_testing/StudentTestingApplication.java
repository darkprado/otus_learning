package com.example.student_testing;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.student_testing.service.StudentTestingService;

public class StudentTestingApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        StudentTestingService studentTestingService = context.getBean(StudentTestingService.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        System.out.println("Добро пожаловать " + name);
        studentTestingService.test();
    }

}
