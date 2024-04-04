package com.crio.rentread.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserService implements UserDetailsService{

    
    // PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

   

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepository.findByEmail(username);
    }

    
    
}
