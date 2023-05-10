package com.example.talentmanagemnet.config.security.filter;//package com.example.loyaltycard.config.security.filter;
//
//import com.auth0.jwt.JWT;
//import com.example.loyaltycard.config.security.jwt.JWTUtils;
//import com.example.loyaltycard.dto.user.LoginDto;
//import com.example.loyaltycard.entity.user.AuthUser;
//import com.example.loyaltycard.exception.exception.NotFoundException;
//import com.example.loyaltycard.repository.user.AuthUserRepository;
//import com.example.loyaltycard.response.AppError;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import java.io.IOException;
//import java.util.Date;
//
//public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private final AuthenticationManager authenticationManager;
//    private final AuthUserRepository userRepository;
//
//    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, AuthUserRepository userRepository) {
//        this.authenticationManager = authenticationManager;
//        this.userRepository = userRepository;
//        super.setFilterProcessesUrl("/users/login");
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        try {
//            LoginDto dto = new ObjectMapper().readValue(request.getReader(), LoginDto.class);
//            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
//            return authenticationManager.authenticate(token);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        User user = (User) authResult.getPrincipal();
//        Date accessDate = JWTUtils.getExpiry();
//
//        String accessToken = JWT.create().withSubject(user.getUsername())
//                .withExpiresAt(accessDate).withIssuer(request.getRequestURL().toString())
//                .sign(JWTUtils.getAlgorithm());
//
//        userRepository.findByEmail(user.getUsername())
//                .orElseThrow(() -> new NotFoundException("User not found"));
//
//
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        new ObjectMapper().writeValue(response.getOutputStream(), "Bearer "+accessToken);
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
//        AppError errorData = new AppError(failed.getMessage(), HttpStatus.UNAUTHORIZED);
//        new ObjectMapper().writeValue(response.getOutputStream(), errorData);
//    }
//}
