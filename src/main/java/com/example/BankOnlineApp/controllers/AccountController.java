package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.DTO.AccountDTO;
import com.example.BankOnlineApp.controllers.controllerInterfaces.AccountControllerInterface;
import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.CheckingAccount;
import com.example.BankOnlineApp.entities.account.CreditCard;
import com.example.BankOnlineApp.entities.account.Savings;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
import com.example.BankOnlineApp.services.AccountService;
import com.example.BankOnlineApp.services.serviceInterfaces.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class AccountController implements AccountControllerInterface {

    @Autowired
    AccountService accountService;

    //create new CreditCard

    @PostMapping("/new-credit")
    public CreditCard newCreditCard(@RequestBody AccountDTO accountDTO){
        return accountService.createCreditCard(accountDTO);
    }

    //create new Savings
    @PostMapping("/new-savings")
    public Savings newSavings(@RequestBody AccountDTO accountDTO){
        return accountService.createSavings(accountDTO);
    }

    //create new CheckingAccount
    @PostMapping("/new-CheckingAccount")
    public CheckingAccount newCheckingAccount(@RequestBody AccountDTO accountDTO){
        return accountService.createCheckingAccount(accountDTO);
    }

    //check balance
    @GetMapping("/account/{idAccountNumber}/balance")
    public Money getBalance(@PathVariable Long idAccountNumber){
        return accountService.getBalance(idAccountNumber);
    }

    //receive funds
//    @PutMapping("account/{idAccountNumber}/receive")
//    public void receiveFunds(@PathVariable Long idAccountNumber)

}
