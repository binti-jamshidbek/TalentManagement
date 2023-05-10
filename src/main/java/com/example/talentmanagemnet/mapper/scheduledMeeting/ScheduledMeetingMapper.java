package com.example.talentmanagemnet.mapper.scheduledMeeting;

import com.example.talentmanagemnet.dto.meeting.scheduledMeeting.ScheduledMeetingCreDto;
import com.example.talentmanagemnet.dto.meeting.scheduledMeeting.ScheduledMeetingDto;
import com.example.talentmanagemnet.dto.meeting.scheduledMeeting.ScheduledMeetingUptDto;
import com.example.talentmanagemnet.entity.meeting.scheduledMeeting.ScheduledMeeting;
import com.example.talentmanagemnet.mapper.AbstractMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ScheduledMeetingMapper extends AbstractMapper<
        ScheduledMeeting,
        ScheduledMeetingDto,
        ScheduledMeetingCreDto,
        ScheduledMeetingUptDto> {
}
