package com.crio.rentread.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crio.rentread.exchange.BookRequest;
import com.crio.rentread.model.Book;
import com.crio.rentread.service.BookService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> postBook(@RequestBody BookRequest bookRequest) {
        return new ResponseEntity<>(bookService.addBook(bookRequest),HttpStatus.CREATED);
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> putMethodName(@PathVariable(value = "bookId") String bookId, @RequestBody BookRequest bookRequest) {
        return new ResponseEntity<>(bookService.updateBook(bookId, bookRequest),HttpStatus.OK);
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "bookId")String bookId){
        return new ResponseEntity<>(bookService.deleteBook(bookId),HttpStatus.NO_CONTENT);
    }
    
}
