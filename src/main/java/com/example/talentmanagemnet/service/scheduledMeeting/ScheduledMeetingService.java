package com.example.talentmanagemnet.service.scheduledMeeting;

import com.example.talentmanagemnet.dto.meeting.scheduledMeeting.*;
import com.example.talentmanagemnet.service.BaseService;

import java.util.List;

public interface ScheduledMeetingService extends BaseService {
    ScheduledMeetingDto get(String id);

    String create(ScheduledMeetingCreDto dto);

    Boolean delete(String id);
    void deleteByTestCenterId(String id);

    List<ScheduledMeetingDto> searchScheduledMeeting(SearchScheduledMeetingDto dto);

    ScheduledMeetingDto update(ScheduledMeetingUptDto dto);

    Boolean bookMeeting(BookMeetingDto dto);
}
