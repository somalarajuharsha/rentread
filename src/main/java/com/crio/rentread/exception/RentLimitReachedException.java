package com.crio.rentread.exception;

public class RentLimitReachedException extends RuntimeException {
    public RentLimitReachedException(String msg){
        super(msg);
    }
}
