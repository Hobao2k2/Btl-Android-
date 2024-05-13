package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAM {

    private String title;
    private List<AnswerAM> answers;
    private String topic;
    private String level;
    private int stt;
}
