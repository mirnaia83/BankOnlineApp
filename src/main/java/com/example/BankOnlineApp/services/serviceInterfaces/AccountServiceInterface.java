package com.example.BankOnlineApp.services.serviceInterfaces;

import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.Money;

public interface AccountServiceInterface {
    void createAccount(Account account);


    Money getBalance(Long idAccountNumber);
}
