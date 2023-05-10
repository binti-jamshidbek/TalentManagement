package com.example.talentmanagemnet.mapper.area;

import com.example.talentmanagemnet.dto.area.CountryCreDto;
import com.example.talentmanagemnet.dto.area.CountryUptDto;
import com.example.talentmanagemnet.entity.area.Country;
import com.example.talentmanagemnet.mapper.AbstractMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CountryMapper extends AbstractMapper<
        Country,
        String,
        CountryCreDto,
        CountryUptDto> {
}
