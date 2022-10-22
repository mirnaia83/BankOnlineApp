package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.DTO.AccountHolderDTO;
import com.example.BankOnlineApp.controllers.controllerInterfaces.AccountHolderControllerInterface;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.services.AccountHolderService;
import com.example.BankOnlineApp.services.serviceInterfaces.AccountHolderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountHolderController implements AccountHolderControllerInterface {

    @Autowired
    AccountHolderService accountHolderService;

    @Autowired
    AccountController accountController;

    @Autowired
    AccountHolderServiceInterface accountHolderServiceInterface;
    @Autowired
    AccountHolderDTO accountHolderDTO;

    //register new accountHolder
    @PostMapping("/accountHolder")
    public AccountHolder registerAccountHolder(@RequestBody AccountHolder accountHolder) {
        return accountHolderService.registerAccountHolder(accountHolder);

    }

    //transfer balance
    @PatchMapping("/transferAccountHolder")
    @ResponseStatus(HttpStatus.OK)
    public Money transferMoney(@RequestBody AccountHolderDTO accountHolderDTO){
        return  accountHolderServiceInterface.transferMoney(accountHolderDTO.getIdAccountNumber(), accountHolderDTO.getAmount(), accountHolderDTO.getIdAccountNumber1());
    }

}
