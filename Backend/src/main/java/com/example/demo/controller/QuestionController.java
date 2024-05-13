package com.example.demo.controller;

import com.example.demo.dto.AnswerDto;
import com.example.demo.dto.QuestionAM;
import com.example.demo.dto.QuestionDto;
import com.example.demo.dto.QuestionUM;
import com.example.demo.model.Answer;
import com.example.demo.model.New;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.example.demo.repository.NewRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionService;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
   @Autowired
    QuestionService questionService;
   @Autowired
    UserService userService;
   @Autowired
    NewRepository newRepository;
    @GetMapping("/{id}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable int id){
        QuestionDto questionDto=questionService.getById(id);
        return ResponseEntity.ok(questionDto);
    }
    @GetMapping
    public ResponseEntity<List<QuestionDto>> getAll(){
        List<QuestionDto> listQuestionDto=questionService.getAll();
//        List<Question> listQuestion=questionRepository.findAll();
//        List<QuestionDto> listQuestionDto=new ArrayList<>();
//        for(Question question:listQuestion){
//            listQuestionDto.add(modelMapper.map(question,QuestionDto.class));
//        }
       return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);

    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @GetMapping("/sort")
    public List<User> getAllUserSortByDiem(){
        return userService.findAllByOrderByDiemDesc();
    }
    @PostMapping
    public ResponseEntity<QuestionDto> addQuestion(@RequestBody QuestionAM questionAM){
        QuestionDto questionDto=questionService.addQuestion(questionAM);
        return new ResponseEntity<QuestionDto>(questionDto, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<QuestionDto> updateQuestion(@PathVariable int id,@RequestBody QuestionUM questionUM){
        QuestionDto questionDto=questionService.updateQuestion(id,questionUM );
        return new ResponseEntity<QuestionDto>(questionDto,HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable int id){
        questionService.deleteQuestion(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/toan-de")
    public List<New> getToanDeNews() {
        return newRepository.findToanDeNews();
    }
    @GetMapping("/toan-de-1")
    public ResponseEntity<List<QuestionDto>> getFindToanDe1(){
        List<QuestionDto> listQuestionDto=questionService.findToanDe1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/toan-de-2")
    public ResponseEntity<List<QuestionDto>> getFindToanDe2(){
        List<QuestionDto> listQuestionDto=questionService.findToanDe2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/toan-de-3")
    public ResponseEntity<List<QuestionDto>> getFindToanDe3(){
        List<QuestionDto> listQuestionDto=questionService.findToanDe3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/toan-trung-binh-1")
    public ResponseEntity<List<QuestionDto>> getFindToanTrungBinh1(){
        List<QuestionDto> listQuestionDto=questionService.findToanTrungBinh1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/toan-trung-binh-2")
    public ResponseEntity<List<QuestionDto>> getFindToanTrungBinh2(){
        List<QuestionDto> listQuestionDto=questionService.findToanTrungBinh2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/toan-trung-binh-3")
    public ResponseEntity<List<QuestionDto>> getFindToanTrungBinh3(){
        List<QuestionDto> listQuestionDto=questionService.findToanTrungBinh3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/toan-kho-1")
    public ResponseEntity<List<QuestionDto>> getFindToanKho1(){
        List<QuestionDto> listQuestionDto=questionService.findToanKho1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/toan-kho-2")
    public ResponseEntity<List<QuestionDto>> getFindToanKho2(){
        List<QuestionDto> listQuestionDto=questionService.findToanKho2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/toan-kho-3")
    public ResponseEntity<List<QuestionDto>> getFindToanKho3(){
        List<QuestionDto> listQuestionDto=questionService.findToanKho3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/khoa-hoc-de-1")
    public ResponseEntity<List<QuestionDto>> getFindKhoaHocDe1(){
        List<QuestionDto> listQuestionDto=questionService.findKhoaHocDe1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/khoa-hoc-de-2")
    public ResponseEntity<List<QuestionDto>> getFindKhoaHocDe2(){
        List<QuestionDto> listQuestionDto=questionService.findKhoaHocDe2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/khoa-hoc-de-3")
    public ResponseEntity<List<QuestionDto>> getFindKhoaHocDe3(){
        List<QuestionDto> listQuestionDto=questionService.findKhoaHocDe3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/khoa-hoc-trung-binh-1")
    public ResponseEntity<List<QuestionDto>> getFindKhoaHocTrungBinh1(){
        List<QuestionDto> listQuestionDto=questionService.findKhoaHocTrungBinh1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/khoa-hoc-trung-binh-2")
    public ResponseEntity<List<QuestionDto>> getFindKhoaHocTrungBinh2(){
        List<QuestionDto> listQuestionDto=questionService.findKhoaHocTrungBinh2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/khoa-hoc-trung-binh-3")
    public ResponseEntity<List<QuestionDto>> getFindKhoaHocTrungBinh3(){
        List<QuestionDto> listQuestionDto=questionService.findKhoaHocTrungBinh3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/khoa-hoc-kho-1")
    public ResponseEntity<List<QuestionDto>> getFindKhoaHocKho1(){
        List<QuestionDto> listQuestionDto=questionService.findKhoaHocKho1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/khoa-hoc-kho-2")
    public ResponseEntity<List<QuestionDto>> getFindKhoaHocKho2(){
        List<QuestionDto> listQuestionDto=questionService.findKhoaHocKho2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/khoa-hoc-kho-3")
    public ResponseEntity<List<QuestionDto>> getFindKhoaHocKho3(){
        List<QuestionDto> listQuestionDto=questionService.findKhoaHocKho3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }


    @GetMapping("/van-hoc-de-1")
    public ResponseEntity<List<QuestionDto>> getFindVanHocDe1(){
        List<QuestionDto> listQuestionDto=questionService.findVanHocDe1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/van-hoc-de-2")
    public ResponseEntity<List<QuestionDto>> getFindVanHocDe2(){
        List<QuestionDto> listQuestionDto=questionService.findVanHocDe2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/van-hoc-de-3")
    public ResponseEntity<List<QuestionDto>> getFindVanHocDe3(){
        List<QuestionDto> listQuestionDto=questionService.findVanHocDe3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/van-hoc-trung-binh-1")
    public ResponseEntity<List<QuestionDto>> getFindVanHocTrungBinh1(){
        List<QuestionDto> listQuestionDto=questionService.findVanHocTrungBinh1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/van-hoc-trung-binh-2")
    public ResponseEntity<List<QuestionDto>> getFindVanHocTrungBinh2(){
        List<QuestionDto> listQuestionDto=questionService.findVanHocTrungBinh2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/van-hoc-trung-binh-3")
    public ResponseEntity<List<QuestionDto>> getFindVanHocTrungBinh3(){
        List<QuestionDto> listQuestionDto=questionService.findVanHocTrungBinh3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/van-hoc-kho-1")
    public ResponseEntity<List<QuestionDto>> getFindVanHocKho1(){
        List<QuestionDto> listQuestionDto=questionService.findVanHocKho1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/van-hoc-kho-2")
    public ResponseEntity<List<QuestionDto>> getFindVanHocKho2(){
        List<QuestionDto> listQuestionDto=questionService.findVanHocKho2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/van-hoc-kho-3")
    public ResponseEntity<List<QuestionDto>> getFindVanHocKho3(){
        List<QuestionDto> listQuestionDto=questionService.findVanHocKho3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/nghe-thuat-de-1")
    public ResponseEntity<List<QuestionDto>> getMyThuatDe1(){
        List<QuestionDto> listQuestionDto=questionService.findMyThuatDe1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/nghe-thuat-de-2")
    public ResponseEntity<List<QuestionDto>> getMyThuatDe2(){
        List<QuestionDto> listQuestionDto=questionService.findMyThuatDe2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/nghe-thuat-de-3")
    public ResponseEntity<List<QuestionDto>> getMyThuatDe3(){
        List<QuestionDto> listQuestionDto=questionService.findMyThuatDe3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/nghe-thuat-trung-binh-1")
    public ResponseEntity<List<QuestionDto>> getMyThuatTrungBinh1(){
        List<QuestionDto> listQuestionDto=questionService.findMyThuatTrungBinh1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/nghe-thuat-trung-binh-2")
    public ResponseEntity<List<QuestionDto>> getMyThuatTrungBinh2(){
        List<QuestionDto> listQuestionDto=questionService.findMyThuatTrungBinh2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/nghe-thuat-trung-binh-3")
    public ResponseEntity<List<QuestionDto>> getMyThuatTrungBinh3(){
        List<QuestionDto> listQuestionDto=questionService.findMyThuatDe3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/nghe-thuat-kho-1")
    public ResponseEntity<List<QuestionDto>> getMyThuatKho1(){
        List<QuestionDto> listQuestionDto=questionService.findMyThuatKho1();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/nghe-thuat-kho-2")
    public ResponseEntity<List<QuestionDto>> getMyThuatKho2(){
        List<QuestionDto> listQuestionDto=questionService.findMyThuatKho2();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
    @GetMapping("/nghe-thuat-kho-3")
    public ResponseEntity<List<QuestionDto>> getMyThuatKho3(){
        List<QuestionDto> listQuestionDto=questionService.findMyThuatKho3();
        return new ResponseEntity<List<QuestionDto>>(listQuestionDto, HttpStatus.OK);
    }
}
