package com.example.talentmanagemnet.service.test;

import com.example.talentmanagemnet.dto.test.QuestionCreDto;
import com.example.talentmanagemnet.dto.test.QuestionDto;
import com.example.talentmanagemnet.service.BaseService;

import java.util.List;

public interface QuestionService extends BaseService {
    List<QuestionDto> getAllByTestId(String testId);
    Void create(List<QuestionCreDto> list, String testId);
    Void deleteAllByTestId(String id);
}
