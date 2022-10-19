package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.controllers.controllerInterfaces.StudentCheckingAccountControllerInterface;
import com.example.BankOnlineApp.services.serviceInterfaces.StudentCheckingAccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentCheckingAccountController implements StudentCheckingAccountControllerInterface {

    @Autowired
    StudentCheckingAccountServiceInterface studentCheckingAccountService;

}
