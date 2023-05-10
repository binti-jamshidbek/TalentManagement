package com.example.talentmanagemnet.service.scheduledMeeting;

import com.example.talentmanagemnet.dto.meeting.scheduledMeeting.*;
import com.example.talentmanagemnet.entity.meeting.scheduledMeeting.ScheduledMeeting;
import com.example.talentmanagemnet.exception.exception.AlreadyCreatedException;
import com.example.talentmanagemnet.exception.exception.InvalidValidationException;
import com.example.talentmanagemnet.exception.exception.NotFoundException;
import com.example.talentmanagemnet.mapper.scheduledMeeting.ScheduledMeetingMapper;
import com.example.talentmanagemnet.repository.scheduledMeeting.ScheduledMeetingRepository;
import com.example.talentmanagemnet.service.AbstractService;
import com.example.talentmanagemnet.service.user.AuthUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class ScheduledMeetingServiceImpl extends AbstractService<ScheduledMeetingRepository, ScheduledMeetingMapper>
        implements ScheduledMeetingService {

    private final AuthUserService userService;

    public ScheduledMeetingServiceImpl(ScheduledMeetingRepository repository, ScheduledMeetingMapper mapper, AuthUserService userService) {
        super(repository, mapper);
        this.userService = userService;
    }

    @Override
    public ScheduledMeetingDto get(String id) {
        if (Objects.isNull(id))
            throw new NotFoundException("Id can not be null");
        ScheduledMeeting meeting = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("TestCenter not found "));
        return mapper.toDto(meeting);
    }

    @Override
    public Boolean delete(String id) {
        if (Objects.isNull(id))
            throw new NotFoundException("Id can not be null");
        if (!repository.existsById(id))
            throw new NotFoundException("Scheduled Meeting not found ");
        repository.deleteById(id);
        return true;
    }

    @Override
    public void deleteByTestCenterId(String testCenterId) {
        if (Objects.isNull(testCenterId))
            throw new NotFoundException("Id can not be null");
        repository.deleteAllByTestCenterId(testCenterId);
    }


    @Override
    public String create(ScheduledMeetingCreDto dto) {
        if (repository.existsByTestCenterIdAndTime(dto.testCenterId(), getFormattedDateTime(dto.time())))
            throw new AlreadyCreatedException("Meeting is already exist for this time");
        if (getFormattedDateTime(dto.time()).isAfter(LocalDateTime.now()))
            throw new InvalidValidationException("Time can not be in the past");
        return repository.save(mapper.fromCreateDto(dto)).getId();
    }

    @Override
    public List<ScheduledMeetingDto> searchScheduledMeeting(SearchScheduledMeetingDto dto) {
        return repository.findAllByTestCenterIdAndDirectionAndTimeAndFullNameIsNull(dto.testCenterId(), dto.direction(), getFormattedDateTime(dto.time()))
                .orElseThrow(()-> new NotFoundException("Not found"))
                .stream()
                .map(item -> new ScheduledMeetingDto(
                        item.getDirection(),
                        item.getTime().format(DateTimeFormatter.ofPattern("MM-dd, HH:mm"))
                )).toList();
    }

    @Override
    public ScheduledMeetingDto update(ScheduledMeetingUptDto dto) {
        if (!repository.existsById(dto.getId()))
            throw new NotFoundException("Scheduled Meeting not found ");
        if (getFormattedDateTime(dto.getTime()).isAfter(LocalDateTime.now()))
            throw new InvalidValidationException("Time can not be in the past");
        ScheduledMeeting save = repository.save(mapper.fromUpdateDto(dto));
        return mapper.toDto(save);
    }

    @Override
    public Boolean bookMeeting(BookMeetingDto dto) {
        ScheduledMeeting meeting = repository.findById(dto.scheduledMeetingId())
                .orElseThrow(() -> new NotFoundException("TestCenter not found "));
        if (!userService.existByPhoneNumber(dto.phoneNumber()))
            throw new NotFoundException("User not found");
        meeting.setFullName(dto.fullName());
        meeting.setPhoneNumber(dto.phoneNumber());
        meeting.setAgreed(dto.agreed());
        repository.save(meeting);
        return true;
    }

    private LocalDateTime getFormattedDateTime(String time) {
        int year = LocalDateTime.now().getYear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        return LocalDateTime.parse(year + "-" + time, formatter);
    }
}
