package com.ograeset.talkbackend.service;

import com.ograeset.talkbackend.model.User;
import com.ograeset.talkbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public  class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = null;
        try {
            userList = new ArrayList<>(userRepository.findAll());

            return new ResponseEntity<>(userList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> addNewUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}