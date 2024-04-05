package com.crio.rentread.exception;

public class UserNotFoundException  extends RuntimeException{
    public UserNotFoundException(String msg){
        super(msg);
    }
}
