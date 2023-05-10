package com.example.talentmanagemnet.config.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenApiConfigurer {
        private static final String BEARER_FORMAT = "JWT";
        private static final String SCHEME = "Bearer";
        private static final String SECURITY_SCHEME_NAME = "Security Scheme";


        @Bean
        public OpenAPI api() {
                return new OpenAPI()
                        .schemaRequirement(SECURITY_SCHEME_NAME, getSecurityScheme())
                        .info(getInfo())
                        .security(getSecurityRequirement());
        }

        private List<io.swagger.v3.oas.models.security.SecurityRequirement> getSecurityRequirement() {
                io.swagger.v3.oas.models.security.SecurityRequirement securityRequirement = new io.swagger.v3.oas.models.security.SecurityRequirement();
                securityRequirement.addList(SECURITY_SCHEME_NAME);
                List<io.swagger.v3.oas.models.security.SecurityRequirement> list = new ArrayList<>();
                list.add(securityRequirement);
                return list;
        }

        private io.swagger.v3.oas.models.security.SecurityScheme getSecurityScheme() {
                io.swagger.v3.oas.models.security.SecurityScheme securityScheme = new io.swagger.v3.oas.models.security.SecurityScheme();
                securityScheme.bearerFormat(BEARER_FORMAT);
                securityScheme.type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP);
                securityScheme.in(io.swagger.v3.oas.models.security.SecurityScheme.In.HEADER);
                securityScheme.scheme(SCHEME);
                return securityScheme;
        }
        private io.swagger.v3.oas.models.info.Info getInfo(){
                io.swagger.v3.oas.models.info.Info info = new io.swagger.v3.oas.models.info.Info();
                info.title("Talent Management Service");
                info.version("version 1.0");
                info.description("This application helps to find suitable offers and jobs for your major");
                info.contact(new io.swagger.v3.oas.models.info.Contact().name("Rakh1sta").url("https://t.me/rakh1sta").email("shoxistarakhimova@gmail.com"));
                return info;
        }
}