package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.model.New;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.NewRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questions/")
public class Controller {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private NewRepository newRepository;
    @GetMapping("news")
    public List<New> getAllNews(){
        return newRepository.findAll();
    }
    @GetMapping("answers")
    public List<Answer> getAllAnswer(){
        return answerRepository.findAll();
    }
    @GetMapping("{id}")
    public Question getQuestionById(@PathVariable Integer id){
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("lỗi"));

    }
    @GetMapping("news/{toanhoc}/{de}")
    public List<New> getAllNews(@PathVariable String topic,String level){
        return newRepository.findByTopicAndLevel(topic,level);
    }


}
