package com.example.talentmanagemnet.mapper.test;


import com.example.talentmanagemnet.dto.test.TestCreDto;
import com.example.talentmanagemnet.dto.test.TestDto;
import com.example.talentmanagemnet.dto.test.TestUptDto;
import com.example.talentmanagemnet.entity.test.Test;
import com.example.talentmanagemnet.mapper.AbstractMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TestMapper extends AbstractMapper<
        Test,
        TestDto,
        TestCreDto,
        TestUptDto> {
}
