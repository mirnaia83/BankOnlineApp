package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.services.serviceInterfaces.UserServiceInterface;
import com.example.BankOnlineApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {


    @Autowired
    UserRepository userRepository;


}

