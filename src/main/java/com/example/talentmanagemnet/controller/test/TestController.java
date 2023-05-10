package com.example.talentmanagemnet.controller.test;

import com.example.talentmanagemnet.controller.AbstractController;
import com.example.talentmanagemnet.dto.test.TestCreDto;
import com.example.talentmanagemnet.dto.test.TestDto;
import com.example.talentmanagemnet.response.Data;
import com.example.talentmanagemnet.service.test.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController extends AbstractController<TestService> {
    public TestController(TestService service) {
        super(service);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Data<TestDto>> get(@PathVariable String name) {
        return ResponseEntity.ok(new Data<>(service.get(name)));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Data<String>> create(@RequestBody TestCreDto dto) {
        return ResponseEntity.ok(new Data<>(service.create(dto)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable String id) {
        return ResponseEntity.ok(new Data<>(service.delete(id)));
    }

}
