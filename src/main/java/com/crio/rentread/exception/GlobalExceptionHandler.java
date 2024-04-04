package com.crio.rentread.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<String> handlerEmailExist(EmailExistException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
    }
    
}
