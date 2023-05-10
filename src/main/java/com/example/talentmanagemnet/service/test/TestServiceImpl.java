package com.example.talentmanagemnet.service.test;

import com.example.talentmanagemnet.dto.test.TestCreDto;
import com.example.talentmanagemnet.dto.test.TestDto;
import com.example.talentmanagemnet.entity.test.Test;
import com.example.talentmanagemnet.exception.exception.AlreadyCreatedException;
import com.example.talentmanagemnet.exception.exception.NotFoundException;
import com.example.talentmanagemnet.mapper.test.TestMapper;
import com.example.talentmanagemnet.repository.test.TestRepository;
import com.example.talentmanagemnet.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TestServiceImpl extends AbstractService<TestRepository, TestMapper>
        implements TestService {
    private final QuestionService questionService;

    public TestServiceImpl(TestRepository repository, TestMapper mapper, QuestionService questionService) {
        super(repository, mapper);
        this.questionService = questionService;
    }

    @Override
    public TestDto get(String name) {

        Test testNotFound = repository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Test not found"));
        return new TestDto(testNotFound.getName(), questionService.getAllByTestId(testNotFound.getId()));
    }

    @Override
    public Boolean delete(String id) {
        if (Objects.isNull(id))
            throw new NotFoundException("Id can not be null");
        if (!repository.existsById(id))
            throw new NotFoundException("Test not found");
        repository.deleteById(id);
        return true;
    }

    @Override
    public String create(TestCreDto dto) {
        if (repository.existsByName(dto.name()))
            throw new AlreadyCreatedException("Already exist test with the name " + dto.name());
        Test save = repository.save(mapper.fromCreateDto(dto));
        questionService.create(dto.questions(),save.getId());
        return save.getId();
    }

    @Override
    public List<String> getAllDirections() {
        List<String> list = repository.findAllDirections();
        if (list.isEmpty())
            throw new NotFoundException("Not found any direction");
        return list;
    }
}
