package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.controllers.controllerInterfaces.CheckingAccountControllerInterface;
import com.example.BankOnlineApp.services.CheckingAccountService;
import com.example.BankOnlineApp.services.serviceInterfaces.CheckingAccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckingAccountController implements CheckingAccountControllerInterface {

@Autowired
CheckingAccountService checkingAccountService;





}
