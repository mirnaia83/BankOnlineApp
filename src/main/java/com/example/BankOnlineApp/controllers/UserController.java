package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.controllers.controllerInterfaces.UserControllerInterface;
import com.example.BankOnlineApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserControllerInterface {

    @Autowired
    UserRepository userRepository;

//    @GetMapping("/users")
//    public List<User> findAll(@AuthenticationPrincipal UserDetails userDetails) {
//        System.out.println(userDetails.getUsername());
//
//        return userRepository.findAll();
//    }
}




