package com.example.demo.service;

import com.example.demo.dto.QuestionDto;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAll();
    List<User> findAllByOrderByDiemDesc();
}
