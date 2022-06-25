package com.example.spid.exceptions.exceptionHandler;

import com.example.spid.exceptions.ApiError;
import com.example.spid.exceptions.customExceptions.NoSpidsFoundException;
import com.example.spid.exceptions.customExceptions.NoUserFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NoSpidsFoundException.class)
    public ResponseEntity<ApiError> hanldeEmptyPassword (NoSpidsFoundException ex){
        return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, ex.getMessage(), ex));
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<ApiError> hanldeEmptyPassword (NoUserFoundException ex){
        return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, ex.getMessage(), ex));
    }
    public ResponseEntity<ApiError> buildResponseEntity (ApiError apiError){
        return new ResponseEntity(apiError, apiError.getStatus());
    }
}
