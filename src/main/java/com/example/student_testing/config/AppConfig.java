package com.example.student_testing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.student_testing.service.QuestionsService;
import com.example.student_testing.service.QuestionsServiceImpl;
import com.example.student_testing.service.StudentTestingService;
import com.example.student_testing.service.StudentTestingServiceImpl;

/**
 * @author s.melekhin
 * @since 16 май 2022 г.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    QuestionsService questionsService(@Value("${file.fileName}") String fileName) {
        return new QuestionsServiceImpl(fileName);
    }

    @Bean
    StudentTestingService studentTestingService(QuestionsService questionsService) {
        return new StudentTestingServiceImpl(questionsService);
    }

}
