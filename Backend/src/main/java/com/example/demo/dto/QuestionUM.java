package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionUM {
    private int id;
    private String title;
    private List<AnswerUM> answers;
    private String topic;
    private String level;
    private int stt;
}

