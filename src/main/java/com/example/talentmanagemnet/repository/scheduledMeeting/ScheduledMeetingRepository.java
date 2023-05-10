package com.example.talentmanagemnet.repository.scheduledMeeting;

import com.example.talentmanagemnet.entity.meeting.scheduledMeeting.ScheduledMeeting;
import com.example.talentmanagemnet.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduledMeetingRepository extends JpaRepository<ScheduledMeeting,String>,BaseRepository {
    void deleteAllByTestCenterId(String testCenterId);
    boolean existsByTestCenterIdAndTime(String testCenterId, LocalDateTime time);

    Optional<List<ScheduledMeeting>> findAllByTestCenterIdAndDirectionAndTimeAndFullNameIsNull(String testCenterId, String direction, LocalDateTime time);
}
