package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.services.serviceInterfaces.SavingsServiceInterface;
import com.example.BankOnlineApp.repositories.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsService implements SavingsServiceInterface {

    @Autowired
    SavingsRepository savingsRepository;




}
