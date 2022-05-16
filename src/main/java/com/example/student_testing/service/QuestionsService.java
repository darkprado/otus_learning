package com.example.student_testing.service;

import java.util.List;

import com.example.student_testing.dto.QuestionDto;

/**
 * @author s.melekhin
 * @since 12 май 2022 г.
 */
public interface QuestionsService {

    List<QuestionDto> getQuestionsFromCSV();

}
