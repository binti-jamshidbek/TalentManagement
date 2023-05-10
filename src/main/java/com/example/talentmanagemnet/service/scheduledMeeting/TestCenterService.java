package com.example.talentmanagemnet.service.scheduledMeeting;

import com.example.talentmanagemnet.dto.meeting.testCenter.TestCenterCreDto;
import com.example.talentmanagemnet.dto.meeting.testCenter.TestCenterDto;
import com.example.talentmanagemnet.service.BaseService;

import java.util.List;

public interface TestCenterService extends BaseService {
    TestCenterDto get(String id);

    String create(TestCenterCreDto dto);

    Boolean delete(String id);

    List<String> getAllByCountyId(String countryId);

}
