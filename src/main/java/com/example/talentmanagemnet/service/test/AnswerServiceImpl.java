package com.example.talentmanagemnet.service.test;

import com.example.talentmanagemnet.dto.test.AnswerCreDto;
import com.example.talentmanagemnet.dto.test.AnswerDto;
import com.example.talentmanagemnet.entity.test.Answer;
import com.example.talentmanagemnet.exception.exception.NotFoundException;
import com.example.talentmanagemnet.mapper.test.AnswerMapper;
import com.example.talentmanagemnet.repository.test.AnswerRepository;
import com.example.talentmanagemnet.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnswerServiceImpl extends AbstractService<AnswerRepository, AnswerMapper> implements AnswerService{


    public AnswerServiceImpl(AnswerRepository repository, AnswerMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public List<AnswerDto> getAllByQuestionId(String questionId) {
        List<Answer> allByQuestionId = repository.findAllByQuestionId(questionId);
        if (allByQuestionId.isEmpty())
            throw new NotFoundException("Answer not found");
        return mapper.toDto(allByQuestionId);
    }

    @Override
    public Boolean delete(String id) {
        if (Objects.isNull(id))
            throw new NotFoundException("Id can not be null");
        if (!repository.existsById(id))
            throw new NotFoundException("Answer not found");
        repository.deleteById(id);
        return true;
    }

    @Override
    public void deleteAllByQuestionId(String questionId) {
        if (Objects.isNull(questionId))
            throw new NotFoundException("Id can not be null");
        repository.deleteAllByQuestionId(questionId);
    }

    @Override
    public Void create(List<AnswerCreDto> answer, String questionId) {
        answer.forEach(item -> {
            Answer answer1 = mapper.fromCreateDto(item);
            answer1.setQuestionId(questionId);
            repository.save(answer1);
        });
        return null;
    }

}
