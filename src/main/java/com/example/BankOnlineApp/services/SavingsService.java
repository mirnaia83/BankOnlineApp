package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.DTO.AccountDTO;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.Savings;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.SavingsServiceInterface;
import com.example.BankOnlineApp.repositories.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SavingsService implements SavingsServiceInterface {

    @Autowired
    SavingsRepository savingsRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    public void createSavings(AccountDTO accountDTO, String id) {
        if (accountHolderRepository.findById(id).isPresent()) {

            Savings savingsAccount = new Savings();

            savingsAccount.setMoney(new Money(accountDTO.getCurrency(), accountDTO.getBalance()));
            savingsAccount.setSecretKey(accountDTO.getSecretKey());
            savingsAccount.setPrimaryOwner(accountHolderRepository.findById(id).get());
            if (accountDTO.getSecondaryOwner() != null) {
                savingsAccount.setSecondaryOwner(accountDTO.getSecondaryOwner());}
            if (accountDTO.getMinimumBalance() != null) {
                savingsAccount.setMinimumBalance(accountDTO.getMinimumBalance());
            }
            savingsAccount.setCreationDate(accountDTO.getCreationDate());
            if (accountDTO.getInterestRate() == null) {

            } else {
                savingsAccount.setInterestRate(accountDTO.getInterestRate());
            }
            savingsRepository.save(savingsAccount);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "An AccountHolder with this ID doesn't exits in the database");
        }
    }




}
