package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.repositories.AccountRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.AccountHolderServiceInterface;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountHolderService implements AccountHolderServiceInterface {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    AccountRepository accountRepository;

    //register new accountHolder
    public AccountHolder registerAccountHolder(AccountHolder accountHolder){
        return accountHolderRepository.save(accountHolder);
    }



    //access balance









}
