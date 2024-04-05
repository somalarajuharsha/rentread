package com.crio.rentread.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.rentread.exception.BookExistException;
import com.crio.rentread.exception.RentLimitReachedException;
import com.crio.rentread.exception.UserNotFoundException;
import com.crio.rentread.exchange.RentRequest;
import com.crio.rentread.model.Book;
import com.crio.rentread.model.User;
import com.crio.rentread.repository.BookRepository;
import com.crio.rentread.repository.UserRepository;

@Service
public class RentalManagementService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;



    public User rentBook(String bookId,RentRequest rentRequest){
        Optional<User> checkUser=userRepository.findById(Long.parseLong(rentRequest.getUserId()));
        Optional<Book> checkBook=bookRepository.findById(Long.parseLong(bookId));

        User user=checkUser.orElse(null);
        Book book=checkBook.orElse(null);

        if(user==null)
        throw new UserNotFoundException("userId Not found!");
        if(book==null)
        throw new BookExistException("bookId Not found!");

        List<Book> userBooks=user.getBooks();
        if(userBooks.size()>=2)
        throw new RentLimitReachedException("Book limit reached");
        if(book.getStatus())
        throw new BookExistException("Book is in rent!");
        book.setStatus(true);
        userBooks.add(book);
        user.setBooks(userBooks);
        userRepository.save(user);

        return user;
    }



    public User returnBook(String bookId,RentRequest rentRequest) {
        Optional<User> checkUser=userRepository.findById(Long.parseLong(rentRequest.getUserId()));
        Optional<Book> checkBook=bookRepository.findById(Long.parseLong(bookId));

        User user=checkUser.orElse(null);
        Book book=checkBook.orElse(null);

        if(user==null)
        throw new UserNotFoundException("userId Not found!");
        if(book==null)
        throw new BookExistException("bookId Not found!");

        List<Book> userBooks=user.getBooks();
        boolean flag=false;
        for(Book temp:userBooks){
            if(temp.getId()==book.getId()){
                flag=true;
            }
        }
        book.setStatus(false);
        userBooks.remove(book);
        if(!flag)
        throw new BookExistException("user does not rent bookId!");
        user.setBooks(userBooks);
        userRepository.save(user);

        return user;
    }
}
