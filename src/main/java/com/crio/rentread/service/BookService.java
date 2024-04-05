package com.crio.rentread.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.rentread.exception.BookExistException;
import com.crio.rentread.exchange.BookRequest;
import com.crio.rentread.model.Book;
import com.crio.rentread.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(BookRequest bookRequest){
        Book checkBook=bookRepository.findByTitle(bookRequest.getTitle());
        Book book=new Book();
        book.setAuthor(bookRequest.getAuthor());
        book.setGenre(bookRequest.getGenre());
        if(checkBook==null)
        book.setTitle(bookRequest.getTitle());
        else
        throw new BookExistException("Book with title already exist!");
        book.setStatus(false);
        bookRepository.save(book);
        return book;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public String deleteBook(String bookId){
        Optional<Book> checkBook=bookRepository.findById(Long.parseLong(bookId));
        Book book=checkBook.orElse(null);
        if(book==null)
        throw new BookExistException("bookId does not exist");
        bookRepository.deleteById(Long.parseLong(bookId));
        return "Deleted Successfully";
    }

    public Book updateBook(String bookId,BookRequest bookRequest){
        Optional<Book> checkBook=bookRepository.findById(Long.parseLong(bookId));
        Book book=checkBook.orElse(null);
        if(book==null)
        throw new BookExistException("bookId Not found!");
        book.setAuthor(bookRequest.getAuthor());
        book.setGenre(bookRequest.getGenre());
        book.setTitle(bookRequest.getTitle());
        bookRepository.save(book);
        return book;    }
}
