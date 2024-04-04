package com.crio.rentread.exchange;


import com.crio.rentread.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;
    
}
