package com.example.talentmanagemnet.exception;

import com.example.talentmanagemnet.exception.exception.AlreadyCreatedException;
import com.example.talentmanagemnet.exception.exception.InvalidValidationException;
import com.example.talentmanagemnet.exception.exception.NotFoundException;
import com.example.talentmanagemnet.exception.exception.PaymentRequiredException;
import com.example.talentmanagemnet.response.AppError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidValidationException.class)
    public ResponseEntity<AppError> invalidExceptionHandler(InvalidValidationException exception, WebRequest webRequest) {
        AppError applicationError = new AppError();
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(400);
        return new ResponseEntity<>(applicationError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<AppError> notFoundExceptionHandler(NotFoundException exception, WebRequest request) {
        AppError applicationError = new AppError();
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(404);
        return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyCreatedException.class)
    public ResponseEntity<AppError> notFoundExceptionHandler(AlreadyCreatedException exception, WebRequest request) {
        AppError applicationError = new AppError();
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(400);
        return new ResponseEntity<>(applicationError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentRequiredException.class)
    public ResponseEntity<AppError> notFoundExceptionHandler(PaymentRequiredException exception, WebRequest request) {
        AppError applicationError = new AppError();
        applicationError.setMessage(exception.getMessage());
        applicationError.setStatus(402);
        return new ResponseEntity<>(applicationError, HttpStatus.PAYMENT_REQUIRED);
    }


}
