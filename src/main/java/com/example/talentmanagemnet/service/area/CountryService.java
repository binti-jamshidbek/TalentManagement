package com.example.talentmanagemnet.service.area;

import com.example.talentmanagemnet.dto.area.CountryCreDto;
import com.example.talentmanagemnet.dto.area.CountryUptDto;
import com.example.talentmanagemnet.service.BaseService;

import java.util.List;

public interface CountryService extends BaseService {
    List<String> getAll();

    String create(CountryCreDto dto);

    Void delete(String id);

    String update(CountryUptDto dto);

    String get(String id);
}
