package com.example.student_testing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.student_testing.service.StudentTestingService;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class StudentTestingApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentTestingApplication.class);
        StudentTestingService studentTestingService = context.getBean(StudentTestingService.class);
        studentTestingService.test();
    }

}
