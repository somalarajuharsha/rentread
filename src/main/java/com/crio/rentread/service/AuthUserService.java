package com.crio.rentread.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crio.rentread.exception.EmailExistException;
import com.crio.rentread.exchange.UserRequest;
import com.crio.rentread.exchange.UserResponse;
import com.crio.rentread.model.Book;
import com.crio.rentread.model.Role;
import com.crio.rentread.model.User;
import com.crio.rentread.repository.UserRepository;
@Service
public class AuthUserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserResponse registerUser(UserRequest userRequest){
        User emmailCheck=userRepository.findByEmail(userRequest.getEmail());
        
        UserResponse userResponse=new UserResponse();
        if(emmailCheck!=null){
            throw new EmailExistException("Email Id already exists in records!");
        }
        else{
            User user=new User();
            user.setEmail(userRequest.getEmail());
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            if(userRequest.getRole()!=null)
            user.setRole(userRequest.getRole());
            else
            user.setRole(Role.USER);

            userRepository.save(user);

            userResponse.setId(user.getId());
            userResponse.setEmail(user.getEmail());
            userResponse.setName(user.getFirstName()+user.getLastName());
        }

        return userResponse;
    }

    public List<Book> getAllBooksOfUser(String userId) {
        Optional<User> opUser=userRepository.findById(Long.parseLong(userId));
        List<Book> books=new ArrayList<>();
        User user=opUser.orElse(null);
        if(user==null)
        throw new UsernameNotFoundException("userId Not found!");
        books.addAll(user.getBooks());
        return books;
    }

    public String login(User user){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        return "login sucess";
    }
}
