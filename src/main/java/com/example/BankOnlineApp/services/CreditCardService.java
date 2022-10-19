package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.repositories.CreditCardRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.CreditCardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService implements CreditCardServiceInterface {

    @Autowired
    CreditCardRepository creditCardRepository;
}
