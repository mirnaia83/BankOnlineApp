package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.controllers.controllerInterfaces.CreditCardControllerInterface;
import com.example.BankOnlineApp.services.serviceInterfaces.CreditCardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController implements CreditCardControllerInterface {

    @Autowired
    CreditCardServiceInterface creditCardService;

}
