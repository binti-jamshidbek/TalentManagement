package com.example.talentmanagemnet.config.security;//package com.example.loyaltycard.config.security;
//
//import com.example.loyaltycard.config.security.filter.CustomAuthenticationFilter;
//import com.example.loyaltycard.config.security.filter.CustomAuthorizationFilter;
//import com.example.loyaltycard.repository.user.AuthUserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.List;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//@RequiredArgsConstructor
//public class SecurityConfigurer {
//
//    private final PasswordEncoder encoderConfigurer;
//    private final UserDetailsService userDetailsService;
//    private final AuthUserRepository userRepository;
//
//
//    @Bean
//    public AuthenticationManager authManager() {
//        var authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoderConfigurer);
//        return new ProviderManager(authProvider);
//    }
//
//    /*@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/swagger-ui/**", "/api-docs/**","/user/login","user/register","/user/l").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .anyRequest()
//                .fullyAuthenticated()
//                .and()
//                .build();
//    }*/
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests()
//                .requestMatchers(
//                        "/swagger-ui/**",
//                        "/user/**",
//                        "/user/register",
//                        "/swagger-ui.html",
//                        "/api-docs/**")
//                .permitAll()
//                .and()
//                .build();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/api-docs/**");
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOriginPatterns(List.of(
//                "http://localhost:3000"
//        ));
//        configuration.setAllowedHeaders(List.of("*"));
//        configuration.setAllowedMethods(List.of(
//                "GET", "POST", "DELETE", "PUT"
//        ));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}
