package com.example.demo.service;

import com.example.demo.model.New;
import com.example.demo.repository.NewRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewServiceImpl implements NewService{
    @Autowired
    private NewRepository newRepository;
    @Override
    public List<New> findByTopicAndLevel(String topic, String level) {
        return newRepository.findByTopicAndLevel(topic, level);
    }
    public List<New> getToanDeNews() {
        return newRepository.findToanDeNews();
    }
}
