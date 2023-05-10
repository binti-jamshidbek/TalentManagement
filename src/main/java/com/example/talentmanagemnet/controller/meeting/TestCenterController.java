package com.example.talentmanagemnet.controller.meeting;

import com.example.talentmanagemnet.controller.AbstractController;
import com.example.talentmanagemnet.controller.BaseController;
import com.example.talentmanagemnet.dto.meeting.testCenter.TestCenterCreDto;
import com.example.talentmanagemnet.dto.meeting.testCenter.TestCenterDto;
import com.example.talentmanagemnet.response.Data;
import com.example.talentmanagemnet.service.scheduledMeeting.TestCenterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testCenter")
public class TestCenterController extends AbstractController<TestCenterService>
        implements BaseController {
    public TestCenterController(TestCenterService service) {
        super(service);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Data<TestCenterDto>> get(@PathVariable String id) {
        return ResponseEntity.ok(new Data<>(service.get(id)));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Data<String>> create(@RequestBody TestCenterCreDto dto) {
        return ResponseEntity.ok(new Data<>(service.create(dto)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable String id) {
        return ResponseEntity.ok(new Data<>(service.delete(id)));
    }

    @GetMapping(value = "/all/{countryId}")
    public ResponseEntity<Data<List<String>>> getAllByCountryId(@PathVariable String countryId) {
        return ResponseEntity.ok(new Data<>(service.getAllByCountyId(countryId)));
    }


}
