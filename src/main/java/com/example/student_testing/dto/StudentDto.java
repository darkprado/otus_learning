package com.example.student_testing.dto;

/**
 * @author s.melekhin
 * @since 26 май 2022 г.
 */
public class StudentDto {

    private final String name;
    private int points;

    public StudentDto(String name) {
        this.name = name;
        points = 0;
    }

    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }

    public void rightAnswer() {
        points++;
    }
}
