package com.ograeset.talkbackend.user;



import com.ograeset.talkbackend.model.User;
import com.ograeset.talkbackend.repository.UserRepository;
import com.ograeset.talkbackend.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService, UserRepository userRepository){
        this.userService = userService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllUser(){


        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user){


        return userService.addNewUser(user);
    }




}
