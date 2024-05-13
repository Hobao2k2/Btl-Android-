package com.example.demo.dto;

import com.example.demo.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private Integer id;

    private String title;
    private List<AnswerDto> answers;
    private String topic;
    private String level;
    private int stt;
}
