package com.example.talentmanagemnet.controller.auth;

import com.example.talentmanagemnet.controller.AbstractController;
import com.example.talentmanagemnet.dto.user.LoginDto;
import com.example.talentmanagemnet.dto.user.RegisterDto;
import com.example.talentmanagemnet.dto.user.UserDto;
import com.example.talentmanagemnet.dto.user.UserUptDto;
import com.example.talentmanagemnet.response.Data;
import com.example.talentmanagemnet.service.user.AuthUserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<AuthUserServiceImpl> {

    public UserController(AuthUserServiceImpl service) {
        super(service);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Data<Boolean>> register(@RequestBody RegisterDto dto) {
        return ResponseEntity.ok(new Data<>(service.register(dto)));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(service.login(loginDto));
    }

    @PutMapping(value = "/")
    public ResponseEntity<Data<UserDto>> update(@RequestBody UserUptDto dto) {
        return ResponseEntity.ok(new Data<>(service.update(dto)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Data<UserDto>> get(@PathVariable String id) {
        return ResponseEntity.ok(new Data<>(service.get(id)));
    }



}
