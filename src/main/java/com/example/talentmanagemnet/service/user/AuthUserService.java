package com.example.talentmanagemnet.service.user;

import com.example.talentmanagemnet.dto.user.LoginDto;
import com.example.talentmanagemnet.dto.user.RegisterDto;
import com.example.talentmanagemnet.dto.user.UserDto;
import com.example.talentmanagemnet.dto.user.UserUptDto;
import com.example.talentmanagemnet.service.BaseService;

public interface AuthUserService extends BaseService /*, UserDetailsService*/ {

    Object login(LoginDto dto);

    boolean register(RegisterDto dto);

    UserDto update(UserUptDto dto);

    UserDto get(String id);
    Boolean existByPhoneNumber(String phoneNumber);

}
