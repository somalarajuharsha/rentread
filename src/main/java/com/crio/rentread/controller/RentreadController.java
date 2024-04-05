package com.crio.rentread.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crio.rentread.exchange.UserRequest;
import com.crio.rentread.exchange.UserResponse;
import com.crio.rentread.service.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
public class RentreadController {
    

    @Autowired
    private AuthUserService authUserService;



    @GetMapping("/")
    public String getMethodName() {
        return "Rent-Read Service working!";
    }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> postReg(@RequestBody UserRequest userRequest) {
        UserResponse response=authUserService.registerUser(userRequest);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public ResponseEntity<String> postLog(@RequestBody UserRequest userRequest) {

        return ResponseEntity.ok("success");
    }
    @GetMapping("/user")
    public String getUser() {
        return "user api";
    }
    // @GetMapping("/admin")
    // public String getAdmin() {
    //     return "Admin api";
    // }
    
    // @GetMapping("/user/{userId}/books")
    // public ResponseEntity<List<Book>> getAllBooksOfUser(@PathVariable(value = "userId") String userId ) {
    //     return ResponseEntity.ok(authUserService.getAllBooksOfUser(userId));
    // }
    
    
    
}
