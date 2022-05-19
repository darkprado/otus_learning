package com.example.student_testing.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.student_testing.dto.QuestionDto;

/**
 * @author s.melekhin
 * @since 12 май 2022 г.
 */
@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Value("${file.fileName}")
    private String fileName;

    @Override
    public List<QuestionDto> getQuestionsFromCSV() {

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(
                    Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).openStream(), StandardCharsets.UTF_8)
            );
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.newFormat(';'));
            return csvParser.getRecords()
                    .stream()
                    .map(csvRecord -> new QuestionDto(csvRecord.get(0), Arrays.asList(csvRecord.get(1).split(":")), csvRecord.get(2))).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
