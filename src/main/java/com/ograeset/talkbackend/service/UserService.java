package com.ograeset.talkbackend.service;


import com.ograeset.talkbackend.model.User;
import org.springframework.http.ResponseEntity;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService /*extends UserDetailsService*/ {
    /*@Override
    public default UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }*/

    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> addNewUser(User user);
}
