package com.example.demo.service;

import com.example.demo.model.New;

import java.util.List;

public interface NewService {
    List<New> findByTopicAndLevel(String topic, String level);
    List<New> getToanDeNews();
}
