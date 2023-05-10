package com.example.talentmanagemnet.controller.area;

import com.example.talentmanagemnet.controller.AbstractController;
import com.example.talentmanagemnet.controller.BaseController;
import com.example.talentmanagemnet.dto.area.CountryCreDto;
import com.example.talentmanagemnet.dto.area.CountryUptDto;
import com.example.talentmanagemnet.response.Data;
import com.example.talentmanagemnet.service.area.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController extends AbstractController<CountryService> implements BaseController {
    public CountryController(CountryService service) {
        super(service);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Data<String>> get(@PathVariable String id) {
        return ResponseEntity.ok(new Data<>(service.get(id)));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Data<List<String>>> getAll() {
        List<String> all = service.getAll();
        return ResponseEntity.ok(new Data<>(all,all.size()));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Data<String>> create(@RequestBody CountryCreDto dto) {
        return ResponseEntity.ok(new Data<>(service.create(dto)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Data<Void>> delete(@PathVariable String id) {
        return ResponseEntity.ok(new Data<>(service.delete(id)));
    }
    @PutMapping(value = "/")
    public ResponseEntity<Data<String>> update(@RequestBody CountryUptDto dto) {
        return ResponseEntity.ok(new Data<>(service.update(dto)));
    }
}
