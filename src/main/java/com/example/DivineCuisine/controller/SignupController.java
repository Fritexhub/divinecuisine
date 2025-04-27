package com.example.DivineCuisine.controller;

import com.example.DivineCuisine.dto.UserDto;
import com.example.DivineCuisine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.DivineCuisine.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    private final UserRepository userRepository;
    public SignupController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @GetMapping("/signup")
    public String showLoginPage(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "signup";
    }

    @PostMapping("/register")
    public String CreateAccount(@ModelAttribute("userDto") UserDto userDto, Model model){
        System.out.println("Fullname: " + userDto.getFullname() + "\nEmail: " + userDto.getEmail() +
                "\nAddress: " + userDto.getAddress() + "\nPassword: " + userDto.getPassword());
        User user = User.builder()
                .setFullname(userDto.getFullname())
                .setEmail(userDto.getEmail())
                .setAddress(userDto.getAddress())
                .setPassword(userDto.getPassword())
                .build();

        userRepository.save(user);

        model.addAttribute("message", "Registration successful and saved to database!");
        return "Signup";
    }
}
