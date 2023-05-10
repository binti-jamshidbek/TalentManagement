package com.example.talentmanagemnet.mapper.test;

import com.example.talentmanagemnet.dto.test.QuestionCreDto;
import com.example.talentmanagemnet.dto.test.QuestionDto;
import com.example.talentmanagemnet.entity.test.Question;
import com.example.talentmanagemnet.mapper.AbstractMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface QuestionMapper extends AbstractMapper<
        Question,
        QuestionDto,
        QuestionCreDto,
        QuestionDto> {
}
