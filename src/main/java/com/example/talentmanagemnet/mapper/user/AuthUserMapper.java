package com.example.talentmanagemnet.mapper.user;

import com.example.talentmanagemnet.dto.user.RegisterDto;
import com.example.talentmanagemnet.dto.user.UserDto;
import com.example.talentmanagemnet.dto.user.UserUptDto;
import com.example.talentmanagemnet.entity.user.AuthUser;
import com.example.talentmanagemnet.mapper.AbstractMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS )
public interface AuthUserMapper extends AbstractMapper<
        AuthUser,
        UserDto,
        RegisterDto,
        UserUptDto>{

}
