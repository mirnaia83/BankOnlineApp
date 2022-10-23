package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.DTO.AccountDTO;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.CreditCard;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import com.example.BankOnlineApp.repositories.CreditCardRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.CreditCardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreditCardService implements CreditCardServiceInterface {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    public void createCredit(AccountDTO accountDTO, String id) {
        if (accountHolderRepository.findById(id).isPresent()) {

            CreditCard creditCard = new CreditCard();

            creditCard.setMoney(new Money(accountDTO.getCurrency(), accountDTO.getBalance()));
            creditCard.setSecretKey(accountDTO.getSecretKey());
            creditCard.setPrimaryOwner(accountHolderRepository.findById(id).get());
            if (accountDTO.getSecondaryOwner() != null) {
                creditCard.setSecondaryOwner(accountDTO.getSecondaryOwner());}
            if (accountDTO.getInterestRate() == null) {

            } else {
                creditCard.setInterestRate(accountDTO.getInterestRate());
            }
            creditCard.getCreditLimit().setAmount(accountDTO.getCreditLimit());

            creditCardRepository.save(creditCard);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "An AccountHolder with this ID doesn't exits in the database");
        }
    }

}
