package com.example.talentmanagemnet.controller.direction;

import com.example.talentmanagemnet.controller.AbstractController;
import com.example.talentmanagemnet.controller.BaseController;
import com.example.talentmanagemnet.response.Data;
import com.example.talentmanagemnet.service.test.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/direction")
public class DirectionController extends AbstractController<TestService> implements BaseController {
    public DirectionController(TestService service) {
        super(service);
    }

    @GetMapping("/")
    public ResponseEntity<Data<List<String>>> getAllDirections(){
        List<String> list = service.getAllDirections();
        return ResponseEntity.ok(new Data<>(list,list.size()));
    }
}
