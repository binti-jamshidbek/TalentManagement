package com.example.talentmanagemnet.dto.meeting.scheduledMeeting;

import com.example.talentmanagemnet.dto.GenericDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduledMeetingUptDto extends GenericDto {
    private String direction;
    private String time;
}
