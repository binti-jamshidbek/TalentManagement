package com.example.talentmanagemnet.service.user;

import com.example.talentmanagemnet.dto.user.LoginDto;
import com.example.talentmanagemnet.dto.user.RegisterDto;
import com.example.talentmanagemnet.dto.user.UserDto;
import com.example.talentmanagemnet.dto.user.UserUptDto;
import com.example.talentmanagemnet.entity.user.AuthUser;
import com.example.talentmanagemnet.enums.UserRole;
import com.example.talentmanagemnet.exception.exception.AlreadyCreatedException;
import com.example.talentmanagemnet.exception.exception.NotFoundException;
import com.example.talentmanagemnet.mapper.user.AuthUserMapper;
import com.example.talentmanagemnet.repository.user.AuthUserRepository;
import com.example.talentmanagemnet.service.AbstractService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper>
        implements AuthUserService {

    private final RestTemplate restTemplate;
//    private final PasswordEncoder encoder;

    public AuthUserServiceImpl(AuthUserRepository repository, AuthUserMapper mapper, RestTemplate restTemplate/*, PasswordEncoder encoder*/) {
        super(repository, mapper);
        this.restTemplate = restTemplate;
//        this.encoder = encoder;
    }

    @Override
    public Object login(LoginDto dto) {
        HttpEntity<LoginDto> entity = new HttpEntity<>(dto);
        ResponseEntity<Object> exchange = restTemplate.exchange("http://localhost:3000/users/login", HttpMethod.POST, entity, Object.class);
        return exchange.getBody();
    }


    @Override
    public boolean register(RegisterDto dto) {
        if (repository.existsByEmail(dto.email()))
            throw new AlreadyCreatedException("User already exist with this email");

        if (repository.existsByPhoneNumberAndEmail(dto.phoneNumber(), dto.email()))
            throw new AlreadyCreatedException("This user already exist please login");

        AuthUser authUser = mapper.fromCreateDto(dto);
        authUser.setRole(UserRole.USER);
//        authUser.setPassword(encoder.encode(dto.password()));
        repository.save(authUser);
        return true;
    }

    @Override
    public UserDto update(UserUptDto dto) {
        if (repository.existsByEmail(dto.getEmail()))
            throw new AlreadyCreatedException("User already exist with this email");
        if (repository.existsByEmail(dto.getPhoneNumber()))
            throw new AlreadyCreatedException("User already exist with this phone number");
        AuthUser authUser = mapper.fromUpdateDto(dto);
        repository.save(authUser);
        return mapper.toDto(authUser);
    }

    @Override
    public UserDto get(String id) {
        if (Objects.isNull(id))
            throw new AlreadyCreatedException("Id can not be null");
        AuthUser authUser = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return mapper.toDto(authUser);
    }

    @Override
    public Boolean existByPhoneNumber(String phoneNumber) {
        return repository.existsByPhoneNumber(phoneNumber);
    }

    //    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<AuthUser> user = repository.findByEmail(username);
//        if (user.isEmpty())
//            throw new NotFoundException("UNAUTHORIZED");
//        return User.builder()
//                .username(user.get().getEmail())
//                .password(user.get().getPassword())
//                .authorities(new ArrayList<>())
//                .accountLocked(false)
//                .accountExpired(false)
//                .disabled(false)
//                .credentialsExpired(false)
//                .build();
//    }
}
