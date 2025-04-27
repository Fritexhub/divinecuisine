package com.example.DivineCuisine.controller;


import com.example.DivineCuisine.model.User;
import com.example.DivineCuisine.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AllUser {
    private  final UserRepository userRepository;

    public AllUser(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }
}
