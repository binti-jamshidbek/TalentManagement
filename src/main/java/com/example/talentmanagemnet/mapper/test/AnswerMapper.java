package com.example.talentmanagemnet.mapper.test;

import com.example.talentmanagemnet.dto.test.AnswerCreDto;
import com.example.talentmanagemnet.dto.test.AnswerDto;
import com.example.talentmanagemnet.dto.test.AnswerUptDto;
import com.example.talentmanagemnet.entity.test.Answer;
import com.example.talentmanagemnet.mapper.AbstractMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AnswerMapper extends AbstractMapper<
        Answer,
        AnswerDto,
        AnswerCreDto,
        AnswerUptDto> {
}
