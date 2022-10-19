package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.services.serviceInterfaces.CheckingAccountServiceInterface;
import com.example.BankOnlineApp.repositories.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckingAccountService implements CheckingAccountServiceInterface {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;
}
