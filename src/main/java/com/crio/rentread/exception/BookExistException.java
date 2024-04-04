package com.crio.rentread.exception;

public class BookExistException extends RuntimeException{
    public BookExistException(String msg){
        super(msg);
    }
}
