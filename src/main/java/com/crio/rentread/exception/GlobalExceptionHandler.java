package com.crio.rentread.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<String> handlerEmailExist(EmailExistException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
    }
    @ExceptionHandler(BookExistException.class)
    public ResponseEntity<String> handlerBookExist(BookExistException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RentLimitReachedException.class)
    public ResponseEntity<String> handlerRentLimit(RentLimitReachedException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handlerBookExist(UserNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
}
