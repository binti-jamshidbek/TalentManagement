package com.example.talentmanagemnet.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppError {
    private Timestamp timestamp;
    private Integer status;
    private String message;
    private WebRequest request;



    public AppError(String message,  HttpStatus httpStatus) {
        this.status = httpStatus.value();
        this.message = message;
    }


    @Builder
    public AppError(HttpStatus status, String message, WebRequest request) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.status = status.value();
        this.message = message;
        this.request = request;
    }

}
