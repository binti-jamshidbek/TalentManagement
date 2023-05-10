package com.example.talentmanagemnet.config.security.filter;//package com.example.loyaltycard.config.security.filter;
//
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.example.loyaltycard.config.security.jwt.JWTUtils;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class CustomAuthorizationFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if (request.getServletPath().equals("/users/login")) {
//            try {
//                filterChain.doFilter(request, response);
//            } catch (Exception e) {
//                throw new RuntimeException(e.getMessage());
//            }
//        } else {
//            String authorizationHeader = request.getHeader("token");
//            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//                try {
//                    String token = authorizationHeader.substring("Bearer ".length());
//                    DecodedJWT jwt = JWTUtils.getVerifier().verify(token);
//                    String userCode = jwt.getSubject();
//                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userCode, null, new ArrayList<>());
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                    filterChain.doFilter(request, response);
//                } catch (Exception e) {
//                    response.setHeader("error", e.getMessage());
//                    response.setStatus(HttpStatus.FORBIDDEN.value());
//                    Map<String, Object> error = new HashMap<>();
//                    error.put("message", e.getMessage());
//                    error.put("status",403);
//                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                    new ObjectMapper().writeValue(response.getOutputStream(), error);
//                }
//            } else {
//                filterChain.doFilter(request, response);
//            }
//        }
//    }
//
//}
