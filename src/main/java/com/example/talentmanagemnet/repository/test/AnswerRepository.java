package com.example.talentmanagemnet.repository.test;

import com.example.talentmanagemnet.entity.test.Answer;
import com.example.talentmanagemnet.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,String>, BaseRepository {
    List<Answer> findAllByQuestionId(String questionId);

    void deleteAllByQuestionId(String questionId);
}
