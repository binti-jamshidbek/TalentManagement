package com.example.talentmanagemnet.config.encode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PasswordEncoderConfigurer {
//    @Bean
//    public PasswordEncoder encoder() {return new BCryptPasswordEncoder(10);}
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
