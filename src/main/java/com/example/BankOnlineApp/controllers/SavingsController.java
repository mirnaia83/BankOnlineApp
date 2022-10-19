package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.controllers.controllerInterfaces.SavingsControllerInterface;
import com.example.BankOnlineApp.services.serviceInterfaces.SavingsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SavingsController implements SavingsControllerInterface {

    @Autowired
    SavingsServiceInterface savingsService;
}
