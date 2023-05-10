package com.example.talentmanagemnet.controller.meeting;

import com.example.talentmanagemnet.controller.AbstractController;
import com.example.talentmanagemnet.controller.BaseController;
import com.example.talentmanagemnet.dto.meeting.scheduledMeeting.*;
import com.example.talentmanagemnet.response.Data;
import com.example.talentmanagemnet.service.scheduledMeeting.ScheduledMeetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scheduledMeeting")
public class ScheduledMeetingController extends AbstractController<ScheduledMeetingService> implements BaseController {
    public ScheduledMeetingController(ScheduledMeetingService service) {
        super(service);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Data<ScheduledMeetingDto>> get(@PathVariable String id) {
        return ResponseEntity.ok(new Data<>(service.get(id)));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Data<String>> create(@RequestBody ScheduledMeetingCreDto dto) {
        return ResponseEntity.ok(new Data<>(service.create(dto)));
    }

    @PutMapping(value = "/")
    public ResponseEntity<Data<ScheduledMeetingDto>> update(@RequestBody ScheduledMeetingUptDto dto) {
        return ResponseEntity.ok(new Data<>(service.update(dto)));
    }


    @GetMapping(value = "/meetings")
    public ResponseEntity<Data<List<ScheduledMeetingDto>>> getAllByCountryId(@RequestBody SearchScheduledMeetingDto dto) {
        List<ScheduledMeetingDto> list = service.searchScheduledMeeting(dto);
        return ResponseEntity.ok(new Data<>(list,list.size()));
    }

    @PostMapping(value = "/book")
    public ResponseEntity<Data<Boolean>> book(@RequestBody BookMeetingDto dto) {
        return ResponseEntity.ok(new Data<>(service.bookMeeting(dto)));
    }

}
