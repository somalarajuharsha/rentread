package com.crio.rentread.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crio.rentread.exchange.RentRequest;
import com.crio.rentread.model.User;
import com.crio.rentread.service.RentalManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class RentalManagementController {

    @Autowired
    private RentalManagementService rentalManagementService;

    @PostMapping("/books/{bookId}/rent")
    public ResponseEntity<User> postUserBookRent(@PathVariable(value = "bookId") String bookId, @RequestBody RentRequest rentRequest) {
        return new ResponseEntity<>(rentalManagementService.rentBook(bookId,rentRequest),HttpStatus.ACCEPTED);
    }

    @PostMapping("/books/{bookId}/return")
    public ResponseEntity<User> postUserBookReturn(@PathVariable(value = "bookId") String bookId, @RequestBody RentRequest rentRequest) {
        return new ResponseEntity<>(rentalManagementService.returnBook(bookId,rentRequest),HttpStatus.ACCEPTED);
    }
    
}
