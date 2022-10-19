package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.controllers.controllerInterfaces.AccountHolderControllerInterface;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
import com.example.BankOnlineApp.services.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class AccountHolderController implements AccountHolderControllerInterface {

    @Autowired
    AccountHolderService accountHolderService;

    @Autowired
    AccountController accountController;

    //register new accountHolder
    @PostMapping("/accountHolder")
    public AccountHolder registerAccountHolder(@RequestBody AccountHolder accountHolder) {
        return accountHolderService.registerAccountHolder(accountHolder);

    }

    //get balance






//public Bigdecimal transferMoney(Account senderAccount, Account receiverAccount, Bigdecimal amount)
}
