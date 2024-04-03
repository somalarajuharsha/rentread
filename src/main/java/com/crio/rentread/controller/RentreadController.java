package com.crio.rentread.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RentreadController {
    @GetMapping("/")
    public String getMethodName() {
        return "Rentread working!";
    }
    
}
