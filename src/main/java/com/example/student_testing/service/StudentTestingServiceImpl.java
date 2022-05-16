package com.example.student_testing.service;

import java.util.List;

import com.example.student_testing.dto.QuestionDto;

/**
 * @author s.melekhin
 * @since 12 май 2022 г.
 */
public class StudentTestingServiceImpl implements StudentTestingService {

    private final QuestionsService qService;

    public StudentTestingServiceImpl(QuestionsService qService) {
        this.qService = qService;
    }

    @Override
    public void test() {
        List<QuestionDto> questionDtoList = qService.getQuestionsFromCSV();
        questionDtoList.forEach(questionDto -> {
            System.out.println("Вопрос: " + questionDto.getQuestion());
            System.out.println("Выберите вариант ответа:");
            questionDto.getAnswerChoice().forEach(System.out::println);
            System.out.println("Правильный ответ: " + questionDto.getCorrectAnswer());
        });
    }
}
