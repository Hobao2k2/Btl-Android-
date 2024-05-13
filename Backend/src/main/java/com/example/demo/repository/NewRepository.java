package com.example.demo.repository;

import com.example.demo.model.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewRepository extends JpaRepository<New,Integer> {

    List<New> findByTopicAndLevel(String topic, String level);
    @Query("SELECT n FROM New n WHERE n.topic = 'toan' AND n.level = 'de'")
    List<New> findToanDeNews();
}
