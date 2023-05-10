package com.example.talentmanagemnet.service.test;

import com.example.talentmanagemnet.dto.test.AnswerCreDto;
import com.example.talentmanagemnet.dto.test.AnswerDto;
import com.example.talentmanagemnet.service.BaseService;

import java.util.List;

public interface AnswerService extends BaseService {
    List<AnswerDto> getAllByQuestionId(String questionId);

    Void create(List<AnswerCreDto> answer, String questionId);
    Boolean delete(String id);
    void deleteAllByQuestionId(String questionId);
}
