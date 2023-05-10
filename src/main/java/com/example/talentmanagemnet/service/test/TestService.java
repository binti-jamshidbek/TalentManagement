package com.example.talentmanagemnet.service.test;

import com.example.talentmanagemnet.dto.test.TestCreDto;
import com.example.talentmanagemnet.dto.test.TestDto;
import com.example.talentmanagemnet.service.BaseService;

import java.util.List;

public interface TestService extends BaseService {

    TestDto get(String name);

    String create(TestCreDto dto);
    Boolean delete(String id);

    List<String> getAllDirections();
}
