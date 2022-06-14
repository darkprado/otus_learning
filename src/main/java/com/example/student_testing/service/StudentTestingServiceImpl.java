package com.example.student_testing.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.student_testing.dto.QuestionDto;
import com.example.student_testing.dto.StudentDto;

/**
 * @author s.melekhin
 * @since 12 май 2022 г.
 */
@Service
public class StudentTestingServiceImpl implements StudentTestingService {

    @Value("${points.success}")
    private int successPoints;
    private final QuestionsService qService;

    @Autowired
    public StudentTestingServiceImpl(QuestionsService qService) {
        this.qService = qService;
    }

    @Override
    public void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        StudentDto studentDto = new StudentDto(name);
        List<QuestionDto> questionDtoList = qService.getQuestionsFromCSV();
        questionDtoList.forEach(questionDto -> {
            System.out.println("Вопрос: " + questionDto.getQuestion());
            System.out.println("Выберите вариант ответа:");
            questionDto.getAnswerChoice().forEach(System.out::println);
            if (scanner.nextLine().equals(questionDto.getCorrectAnswer())) {
                studentDto.rightAnswer();
            }
        });
        if (studentDto.getPoints() >= successPoints) {
            System.out.printf("Student %s test done!", studentDto.getName());
        } else {
            System.out.printf("Student %s test fail!", studentDto.getName());
        }
    }
}
