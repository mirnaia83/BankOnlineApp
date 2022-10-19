package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.repositories.StudentCheckingAccountRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.StudentCheckingAccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCheckingAccountService implements StudentCheckingAccountServiceInterface {

    @Autowired
    StudentCheckingAccountRepository studentCheckingAccountRepository;
}
