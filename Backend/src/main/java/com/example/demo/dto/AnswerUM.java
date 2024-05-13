package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerUM {
    private int id;
    private String content;
    private String isCorrect;
}
