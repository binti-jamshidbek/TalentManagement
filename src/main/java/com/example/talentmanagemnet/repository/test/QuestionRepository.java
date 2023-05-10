package com.example.talentmanagemnet.repository.test;

import com.example.talentmanagemnet.entity.test.Question;
import com.example.talentmanagemnet.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String>, BaseRepository {
    List<Question> findAllByTestId(String testId);
    void deleteAllByTestId(String testId);

    @Query("select q.id from question q where q.testId =:testId")
    List<String> findAndGetAllByTestId(String testId);
}
