package com.example.talentmanagemnet.dto.meeting.testCenter;

import com.example.talentmanagemnet.dto.GenericDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestCenterUptDto extends GenericDto {
    String name;
    double latitude;
    double longitude;
}
