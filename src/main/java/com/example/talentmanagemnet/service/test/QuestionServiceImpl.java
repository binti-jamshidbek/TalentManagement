package com.example.talentmanagemnet.service.test;

import com.example.talentmanagemnet.dto.test.QuestionCreDto;
import com.example.talentmanagemnet.dto.test.QuestionDto;
import com.example.talentmanagemnet.entity.test.Question;
import com.example.talentmanagemnet.exception.exception.NotFoundException;
import com.example.talentmanagemnet.mapper.test.QuestionMapper;
import com.example.talentmanagemnet.repository.test.QuestionRepository;
import com.example.talentmanagemnet.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl extends AbstractService<QuestionRepository, QuestionMapper> implements QuestionService {

    private final AnswerService answerService;

    public QuestionServiceImpl(QuestionRepository repository, QuestionMapper mapper, AnswerService answerService) {
        super(repository, mapper);
        this.answerService = answerService;
    }



    @Override
    public Void create(List<QuestionCreDto> list, String testId) {
        list.forEach(question -> {
            Question question1 = mapper.fromCreateDto(question);
            question1.setTestId(testId);
            Question save = repository.save(question1);
            answerService.create(question.answers(), save.getId());
        });
        return null;
    }

    @Override
    public Void deleteAllByTestId(String testId) {
        if (Objects.isNull(testId))
            throw new NotFoundException("Id can not be null");
        List<String> andGetAllByTestId = repository.findAndGetAllByTestId(testId);
        andGetAllByTestId.forEach(answerService::deleteAllByQuestionId);
        repository.deleteAllByTestId(testId);
        return null;
    }

    @Override
    public List<QuestionDto> getAllByTestId(String testId) {
        List<Question> allByTestId = repository.findAllByTestId(testId);
        if (allByTestId.isEmpty())
            throw new NotFoundException("Questions not found for this test");

        return allByTestId.stream()
                .map(item -> new QuestionDto(item.getQuestion(),
                        answerService.getAllByQuestionId(item.getId())))
                .collect(Collectors.toList());
    }
}
