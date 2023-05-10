package com.example.talentmanagemnet.service.area;

import com.example.talentmanagemnet.dto.area.CountryCreDto;
import com.example.talentmanagemnet.dto.area.CountryUptDto;
import com.example.talentmanagemnet.entity.area.Country;
import com.example.talentmanagemnet.exception.exception.AlreadyCreatedException;
import com.example.talentmanagemnet.exception.exception.NotFoundException;
import com.example.talentmanagemnet.mapper.area.CountryMapper;
import com.example.talentmanagemnet.repository.area.CountryRepository;
import com.example.talentmanagemnet.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl extends AbstractService<CountryRepository, CountryMapper> implements CountryService {
    public CountryServiceImpl(CountryRepository repository, CountryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public List<String> getAll() {
        return repository.findAll()
                .stream()
                .map(item -> item.getCity()+", " + item.getCountry())
                .toList();
    }

    @Override
    public String create(CountryCreDto dto) {
        if (repository.existsByCityAndCountry(dto.city(), dto.country()))
            throw new AlreadyCreatedException("City already exists for this country");
        return repository.save(mapper.fromCreateDto(dto)).getId();
    }

    @Override
    public Void delete(String id) {
        if (!repository.existsById(id))
            throw new NotFoundException("Country not found");
        repository.deleteById(id);
        return null;
    }

    @Override
    public String update(CountryUptDto dto) {
        if (!repository.existsById(dto.getId()))
            throw new NotFoundException("Country not found");
        if (repository.existsByCityAndCountry(dto.getCity(), dto.getCountry()))
            throw new AlreadyCreatedException("City already exists for this country");
        return repository.save(mapper.fromUpdateDto(dto)).getId();
    }

    @Override
    public String get(String id) {
        Country country = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Country not found"));
        return country.getCity()+", " + country.getCountry();
    }
}
