package com.example.demo.service;

import com.example.demo.dto.QuestionAM;
import com.example.demo.dto.QuestionDto;
import com.example.demo.dto.QuestionUM;

import java.util.List;

public interface QuestionService {
    QuestionDto getById(int id);
    List<QuestionDto> getAll();
    QuestionDto addQuestion(QuestionAM questionAM);
    QuestionDto updateQuestion(int id, QuestionUM questionUM);
    void deleteQuestion(int id);
    List<QuestionDto> findToanDe1();
    List<QuestionDto> findToanDe2();
    List<QuestionDto> findToanDe3();
    List<QuestionDto> findToanTrungBinh1();
    List<QuestionDto> findToanTrungBinh2();
    List<QuestionDto> findToanTrungBinh3();
    List<QuestionDto> findToanKho1();
    List<QuestionDto> findToanKho2();
    List<QuestionDto> findToanKho3();
    List<QuestionDto> findKhoaHocDe1();
    List<QuestionDto> findKhoaHocDe2();
    List<QuestionDto> findKhoaHocDe3();
    List<QuestionDto> findKhoaHocTrungBinh1();
    List<QuestionDto> findKhoaHocTrungBinh2();
    List<QuestionDto> findKhoaHocTrungBinh3();
    List<QuestionDto> findKhoaHocKho1();
    List<QuestionDto> findKhoaHocKho2();
    List<QuestionDto> findKhoaHocKho3();
    List<QuestionDto> findVanHocDe1();
    List<QuestionDto> findVanHocDe2();
    List<QuestionDto> findVanHocDe3();
    List<QuestionDto> findVanHocTrungBinh1();
    List<QuestionDto> findVanHocTrungBinh2();
    List<QuestionDto> findVanHocTrungBinh3();
    List<QuestionDto> findVanHocKho1();
    List<QuestionDto> findVanHocKho2();
    List<QuestionDto> findVanHocKho3();

    List<QuestionDto> findMyThuatDe1();
    List<QuestionDto> findMyThuatDe2();
    List<QuestionDto> findMyThuatDe3();
    List<QuestionDto> findMyThuatTrungBinh1();
    List<QuestionDto> findMyThuatTrungBinh2();
    List<QuestionDto> findMyThuatTrungBinh3();
    List<QuestionDto> findMyThuatKho1();
    List<QuestionDto> findMyThuatKho2();
    List<QuestionDto> findMyThuatKho3();
}
