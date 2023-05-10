package com.example.talentmanagemnet.service.scheduledMeeting;

import com.example.talentmanagemnet.dto.meeting.testCenter.TestCenterCreDto;
import com.example.talentmanagemnet.dto.meeting.testCenter.TestCenterDto;
import com.example.talentmanagemnet.entity.meeting.testCenter.TestCenter;
import com.example.talentmanagemnet.exception.exception.AlreadyCreatedException;
import com.example.talentmanagemnet.exception.exception.NotFoundException;
import com.example.talentmanagemnet.mapper.scheduledMeeting.TestCenterMapper;
import com.example.talentmanagemnet.repository.scheduledMeeting.TestCenterRepository;
import com.example.talentmanagemnet.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TestCenterServiceImpl extends AbstractService<TestCenterRepository, TestCenterMapper>
        implements TestCenterService{

    private final ScheduledMeetingService messagingService;

    public TestCenterServiceImpl(TestCenterRepository repository, TestCenterMapper mapper, ScheduledMeetingService messagingService) {
        super(repository, mapper);
        this.messagingService = messagingService;
    }

    @Override
    public TestCenterDto get(String id) {
        if (Objects.isNull(id))
            throw new NotFoundException("Id can not be null");
        TestCenter testCenterNotFound = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("TestCenter not found "));
        return mapper.toDto(testCenterNotFound);
    }

    @Override
    public String create(TestCenterCreDto dto) {
        if (repository.existsByNameAndCountryId(dto.name(), dto.countryId()))
            throw new AlreadyCreatedException("TestCenter already exists with this country");
        return repository.save(mapper.fromCreateDto(dto)).getId();
    }

    @Override
    public Boolean delete(String id) {
        if (Objects.isNull(id))
            throw new NotFoundException("Id can not be null");
        messagingService.deleteByTestCenterId(id);
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<String> getAllByCountyId(String countryId) {
        if (Objects.isNull(countryId))
            throw new NotFoundException("Id can not be null");
        return repository.findAllNameByCountryId(countryId)
                .orElseThrow(()->new NotFoundException("TestCenter not found for this Country"));
    }
}
