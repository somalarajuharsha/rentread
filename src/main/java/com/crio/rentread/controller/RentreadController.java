package com.crio.rentread.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crio.rentread.exchange.UserRequest;
import com.crio.rentread.exchange.UserResponse;
import com.crio.rentread.model.Book;
import com.crio.rentread.service.AuthUserService;
import com.crio.rentread.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
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
