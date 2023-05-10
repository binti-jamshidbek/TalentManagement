package com.example.talentmanagemnet.mapper.scheduledMeeting;


import com.example.talentmanagemnet.dto.meeting.testCenter.TestCenterCreDto;
import com.example.talentmanagemnet.dto.meeting.testCenter.TestCenterDto;
import com.example.talentmanagemnet.dto.meeting.testCenter.TestCenterUptDto;
import com.example.talentmanagemnet.entity.meeting.testCenter.TestCenter;
import com.example.talentmanagemnet.mapper.AbstractMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TestCenterMapper extends AbstractMapper<
        TestCenter,
        TestCenterDto,
        TestCenterCreDto,
        TestCenterUptDto> {
}
