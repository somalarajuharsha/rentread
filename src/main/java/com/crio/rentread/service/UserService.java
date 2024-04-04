package com.crio.rentread.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crio.rentread.exception.EmailExistException;
import com.crio.rentread.exchange.UserRequest;
import com.crio.rentread.exchange.UserResponse;
import com.crio.rentread.model.Role;
import com.crio.rentread.model.User;
import com.crio.rentread.repository.UserRepository;
@Service
public class UserService implements UserDetailsService{

    // @Autowired
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return userRepository.findByEmail(username);
    }

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
    
}
