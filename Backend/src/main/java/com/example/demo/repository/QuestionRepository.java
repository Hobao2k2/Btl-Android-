package com.example.demo.repository;

import com.example.demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Question getById(int id);
    @Query(value = "SELECT * FROM questions WHERE topic = 'toan hoc' AND level = 'de' AND stt = 1", nativeQuery = true)
    List<Question> findToanDe1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'toan hoc' AND level = 'de' AND stt = 2", nativeQuery = true)
    List<Question> findToanDe2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'toan hoc' AND level = 'de' AND stt = 3", nativeQuery = true)
    List<Question> findToanDe3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'toan hoc' AND level = 'trung binh' AND stt = 1", nativeQuery = true)
    List<Question> findToanTrungBinh1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'toan hoc' AND level = 'trung binh' AND stt = 2", nativeQuery = true)
    List<Question> findToanTrungBinh2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'toan hoc' AND level = 'trung binh' AND stt = 3", nativeQuery = true)
    List<Question> findToanTrungBinh3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'toan hoc' AND level = 'kho' AND stt = 1", nativeQuery = true)
    List<Question> findToanKho1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'toan hoc' AND level = 'kho' AND stt = 2", nativeQuery = true)
    List<Question> findToanKho2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'toan hoc' AND level = 'kho' AND stt = 3", nativeQuery = true)
    List<Question> findToanKho3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'khoa hoc' AND level = 'de' AND stt = 1", nativeQuery = true)
    List<Question> findKhoaHocDe1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'khoa hoc' AND level = 'de' AND stt = 2", nativeQuery = true)
    List<Question> findKhoaHocDe2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'khoa hoc' AND level = 'de' AND stt = 3", nativeQuery = true)
    List<Question> findKhoaHocDe3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'khoa hoc' AND level = 'trung binh' AND stt = 1", nativeQuery = true)
    List<Question> findKhoaHocTrungBinh1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'khoa hoc' AND level = 'trung binh' AND stt = 2", nativeQuery = true)
    List<Question> findKhoaHocTrungBinh2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'khoa hoc' AND level = 'trung binh' AND stt = 3", nativeQuery = true)
    List<Question> findKhoaHocTrungBinh3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'khoa hoc' AND level = 'kho' AND stt = 1", nativeQuery = true)
    List<Question> findKhoaHocKho1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'khoa hoc' AND level = 'kho' AND stt = 2", nativeQuery = true)
    List<Question> findKhoaHocKho2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'khoa hoc' AND level = 'kho' AND stt = 3", nativeQuery = true)
    List<Question> findKhoaHocKho3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'van hoc' AND level = 'de' AND stt = 1", nativeQuery = true)
    List<Question> findVanHocDe1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'van hoc' AND level = 'de' AND stt = 2", nativeQuery = true)
    List<Question> findVanHocDe2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'van hoc' AND level = 'de' AND stt = 3", nativeQuery = true)
    List<Question> findVanHocDe3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'van hoc' AND level = 'trung binh' AND stt = 1", nativeQuery = true)
    List<Question> findVanHocTrungBinh1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'van hoc' AND level = 'trung binh' AND stt = 2", nativeQuery = true)
    List<Question> findVanHocTrungBinh2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'van hoc' AND level = 'trung binh' AND stt = 3", nativeQuery = true)
    List<Question> findVanHocTrungBinh3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'van hoc' AND level = 'kho' AND stt = 1", nativeQuery = true)
    List<Question> findVanHocKho1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'van hoc' AND level = 'kho' AND stt = 2", nativeQuery = true)
    List<Question> findVanHocKho2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'van hoc' AND level = 'kho' AND stt = 3", nativeQuery = true)
    List<Question> findVanHocKho3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'my thuat' AND level = 'de' AND stt = 1", nativeQuery = true)
    List<Question> findMyThuatDe1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'my thuat' AND level = 'de' AND stt = 2", nativeQuery = true)
    List<Question> findMyThuatDe2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'my thuat' AND level = 'de' AND stt = 3", nativeQuery = true)
    List<Question> findMyThuatDe3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'my thuat' AND level = 'trung binh' AND stt = 1", nativeQuery = true)
    List<Question> findMyThuatTrungBinh1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'my thuat' AND level = 'trung binh' AND stt = 2", nativeQuery = true)
    List<Question> findMyThuatTrungBinh2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'my thuat' AND level = 'trung binh' AND stt = 3", nativeQuery = true)
    List<Question> findMyThuatTrungBinh3();
    @Query(value = "SELECT * FROM questions WHERE topic = 'my thuat' AND level = 'kho' AND stt = 1", nativeQuery = true)
    List<Question> findMyThuatKho1();
    @Query(value = "SELECT * FROM questions WHERE topic = 'my thuat' AND level = 'kho' AND stt = 2", nativeQuery = true)
    List<Question> findMyThuatKho2();
    @Query(value = "SELECT * FROM questions WHERE topic = 'my thuat' AND level = 'kho' AND stt = 3", nativeQuery = true)
    List<Question> findMyThuatKho3();

}
