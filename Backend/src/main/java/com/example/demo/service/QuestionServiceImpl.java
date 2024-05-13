package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.util.ConvertUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public QuestionDto getById(int id) {
        Question question=questionRepository.getById(id);
        return ConvertUtil.mappingToObject(question,QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getAll() {
        List<QuestionDto> listQuestionDto=questionRepository.findAll().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public QuestionDto addQuestion(QuestionAM questionAM) {
        Question question=ConvertUtil.mappingToObject(questionAM,Question.class);
        List<Answer> listAnswer=new ArrayList<>();
        for(AnswerAM answerAM:questionAM.getAnswers()){
            Answer answer=ConvertUtil.mappingToObject(answerAM,Answer.class);
            answer.setQuestion(question);
            listAnswer.add(answer);
        }
        question.setAnswers(listAnswer);
        questionRepository.save(question);
        return ConvertUtil.mappingToObject(question,QuestionDto.class);
    }

    @Override
    public QuestionDto updateQuestion(int id, QuestionUM questionUM) {
        Question question=questionRepository.getById(id);
        question.setTitle(questionUM.getTitle());
        question.setTopic(questionUM.getTopic());
        question.setLevel(questionUM.getLevel());
        question.setStt(questionUM.getStt());
        List<Answer> listAnswer=new ArrayList<>();
        for(AnswerUM answerUM:questionUM.getAnswers()){
            Answer answer=ConvertUtil.mappingToObject(answerUM,Answer.class);
            answer.setQuestion(question);
            listAnswer.add(answer);
        }
        question.setAnswers(listAnswer);
        questionRepository.save(question);
        return ConvertUtil.mappingToObject(question,QuestionDto.class);
    }

    @Override
    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public List<QuestionDto> findToanDe1() {
        List<QuestionDto> listQuestionDto=questionRepository.findToanDe1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findToanDe2() {
        List<QuestionDto> listQuestionDto=questionRepository.findToanDe2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findToanDe3() {
        List<QuestionDto> listQuestionDto=questionRepository.findToanDe3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findToanTrungBinh1() {
        List<QuestionDto> listQuestionDto=questionRepository.findToanTrungBinh1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findToanTrungBinh2() {
        List<QuestionDto> listQuestionDto=questionRepository.findToanTrungBinh2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findToanTrungBinh3() {
        List<QuestionDto> listQuestionDto=questionRepository.findToanTrungBinh3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findToanKho1() {
        List<QuestionDto> listQuestionDto=questionRepository.findToanKho1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findToanKho2() {
        List<QuestionDto> listQuestionDto=questionRepository.findToanKho2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findToanKho3() {
        List<QuestionDto> listQuestionDto=questionRepository.findToanKho3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findKhoaHocDe1() {
        List<QuestionDto> listQuestionDto=questionRepository.findKhoaHocDe1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findKhoaHocDe2() {
        List<QuestionDto> listQuestionDto=questionRepository.findKhoaHocDe2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findKhoaHocDe3() {
        List<QuestionDto> listQuestionDto=questionRepository.findKhoaHocDe3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findKhoaHocTrungBinh1() {
        List<QuestionDto> listQuestionDto=questionRepository.findKhoaHocTrungBinh1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findKhoaHocTrungBinh2() {
        List<QuestionDto> listQuestionDto=questionRepository.findKhoaHocTrungBinh2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findKhoaHocTrungBinh3() {
        List<QuestionDto> listQuestionDto=questionRepository.findKhoaHocTrungBinh3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findKhoaHocKho1() {
        List<QuestionDto> listQuestionDto=questionRepository.findKhoaHocKho1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findKhoaHocKho2() {
        List<QuestionDto> listQuestionDto=questionRepository.findKhoaHocKho2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findKhoaHocKho3() {
        List<QuestionDto> listQuestionDto=questionRepository.findKhoaHocKho3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findVanHocDe1() {
        List<QuestionDto> listQuestionDto=questionRepository.findVanHocDe1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findVanHocDe2() {
        List<QuestionDto> listQuestionDto=questionRepository.findVanHocDe2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findVanHocDe3() {
        List<QuestionDto> listQuestionDto=questionRepository.findVanHocDe3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findVanHocTrungBinh1() {
        List<QuestionDto> listQuestionDto=questionRepository.findVanHocTrungBinh1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findVanHocTrungBinh2() {
        List<QuestionDto> listQuestionDto=questionRepository.findVanHocTrungBinh2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findVanHocTrungBinh3() {
        List<QuestionDto> listQuestionDto=questionRepository.findVanHocTrungBinh3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findVanHocKho1() {
        List<QuestionDto> listQuestionDto=questionRepository.findVanHocKho1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findVanHocKho2() {
        List<QuestionDto> listQuestionDto=questionRepository.findVanHocKho2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findVanHocKho3() {
        List<QuestionDto> listQuestionDto=questionRepository.findVanHocKho3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findMyThuatDe1() {
        List<QuestionDto> listQuestionDto=questionRepository.findMyThuatDe1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findMyThuatDe2() {
        List<QuestionDto> listQuestionDto=questionRepository.findMyThuatDe2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findMyThuatDe3() {
        List<QuestionDto> listQuestionDto=questionRepository.findMyThuatDe3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findMyThuatTrungBinh1() {
        List<QuestionDto> listQuestionDto=questionRepository.findMyThuatTrungBinh1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findMyThuatTrungBinh2() {
        List<QuestionDto> listQuestionDto=questionRepository.findMyThuatTrungBinh2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findMyThuatTrungBinh3() {
        List<QuestionDto> listQuestionDto=questionRepository.findMyThuatTrungBinh3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findMyThuatKho1() {
        List<QuestionDto> listQuestionDto=questionRepository.findMyThuatKho1().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findMyThuatKho2() {
        List<QuestionDto> listQuestionDto=questionRepository.findMyThuatKho2().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }

    @Override
    public List<QuestionDto> findMyThuatKho3() {
        List<QuestionDto> listQuestionDto=questionRepository.findMyThuatKho3().stream()
                .map(question -> ConvertUtil.mappingToObject(question,QuestionDto.class)).collect(Collectors.toList());
        return listQuestionDto;
    }
}
