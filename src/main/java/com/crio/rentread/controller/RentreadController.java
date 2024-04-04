package com.crio.rentread.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crio.rentread.exchange.UserRequest;
import com.crio.rentread.exchange.UserResponse;
import com.crio.rentread.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class RentreadController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String getMethodName() {
        return "Rent-Read Service working!";
    }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> postReg(@RequestBody UserRequest userRequest) {
        UserResponse response=userService.registerUser(userRequest);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public String postLog(@RequestBody UserRequest userRequest) {
        return "login working";
    }
    
    
}
