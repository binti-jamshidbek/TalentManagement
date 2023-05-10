package com.example.talentmanagemnet.entity.meeting.scheduledMeeting;

import com.example.talentmanagemnet.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "scheduled_meeting")
public class ScheduledMeeting extends Auditable {
    @Column(nullable = false)
    private String testCenterId;
    @Column(nullable = false)
    private String direction;
    @Column(nullable = false)
    private LocalDateTime time;
    private String fullName;
    private String phoneNumber;
    private boolean agreed;

    @Builder(builderMethodName = "child")
    public ScheduledMeeting(String id, String testCenterId, String direction, LocalDateTime time, String fullName, String phoneNumber, boolean agreed) {
        super(id);
        this.testCenterId = testCenterId;
        this.direction = direction;
        this.time = time;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.agreed = agreed;
    }
}
