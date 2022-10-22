package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.DTO.AccountDTO;
import com.example.BankOnlineApp.controllers.controllerInterfaces.AccountControllerInterface;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.CheckingAccount;
import com.example.BankOnlineApp.entities.account.CreditCard;
import com.example.BankOnlineApp.entities.account.Savings;
import com.example.BankOnlineApp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController implements AccountControllerInterface {

    @Autowired
    AccountService accountService;

    //create new CreditCard

    @PostMapping("/new-creditCard")
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
     @PutMapping("account/{idAccountNumber}/receive")
     public Money receiveFunds(@PathVariable Long idAccountNumber){
        return accountService.getBalance(idAccountNumber);
     }

   //delete account
     @DeleteMapping("/delete/account")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@RequestParam Long id) {

        accountService.deleteAccount(id);

    }


}
