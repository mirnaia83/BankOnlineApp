package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.DTO.AccountDTO;
import com.example.BankOnlineApp.entities.account.*;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import com.example.BankOnlineApp.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    public CreditCard createCreditCard(AccountDTO accountDTO){
        BigDecimal balanceBigDecimal = new BigDecimal(String.valueOf(accountDTO.getBalance()));
        Money balance = new Money(balanceBigDecimal);
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = accountHolderRepository.findById(accountDTO.getSecondaryOwnerId()).get();
        Money creditLimit = new Money(new BigDecimal(String.valueOf(accountDTO.getCreditLimit())));
        Money interestRate = new Money(new BigDecimal(String.valueOf(accountDTO.getInterestRate())));

        CreditCard creditCard = new CreditCard(balance, primaryOwner, secondaryOwner, creditLimit, interestRate);

        return accountRepository.save(creditCard);
    }

    public Savings createSavings(AccountDTO accountDTO){
        BigDecimal balanceBigDecimal = new BigDecimal(String.valueOf(accountDTO.getBalance()));
        Money balance = new Money(balanceBigDecimal);
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = accountHolderRepository.findById(accountDTO.getSecondaryOwnerId()).get();
        Money interestRate = new Money(new BigDecimal(String.valueOf(accountDTO.getInterestRate())));
        BigDecimal minimumBalanceBigDecimal = new BigDecimal(String.valueOf(accountDTO.getMinimumBalance()));
        Money minimumBalance = new Money(minimumBalanceBigDecimal);

        Savings savings = new Savings(balance, primaryOwner, secondaryOwner, interestRate, minimumBalance, LocalDate.now());

        return  accountRepository.save(savings);
    }

    public CheckingAccount createCheckingAccount(AccountDTO accountDTO){
        BigDecimal balanceBigDecimal = new BigDecimal(String.valueOf(accountDTO.getBalance()));
        Money balance = new Money(balanceBigDecimal);
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = accountHolderRepository.findById(accountDTO.getSecondaryOwnerId()).get();
        BigDecimal minimumBalanceBigDecimal = new BigDecimal(String.valueOf(accountDTO.getMinimumBalance()));
        Money minimumBalance = new Money(minimumBalanceBigDecimal);
        Money penaltyFee = new Money(new BigDecimal(accountDTO.getPenaltyFee()));
        Money monthlyMaintenanceFee = new Money(new BigDecimal(accountDTO.getMonthlyMaintenanceFee()));

        if( Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears() >= 24  ){
            CheckingAccount checkingAccount = new CheckingAccount(balance, primaryOwner, secondaryOwner, minimumBalance, penaltyFee,
                    monthlyMaintenanceFee, LocalDate.now(), EnumerationStatus.ACTIVE);
        } else {
            StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount(balance, primaryOwner, secondaryOwner, minimumBalance, penaltyFee,
                    monthlyMaintenanceFee, LocalDate.now(), EnumerationStatus.ACTIVE);}
        return  accountRepository.save(new CheckingAccount(money, secretKey, owner, secondaryOwner, creationDate));


    }

    public Money getBalance(Long idAccountNumber) {
        return accountRepository.findById(idAccountNumber).get().getBalance();
    }

    public Money receiveFunds(Long idAccountNumber){
        return accountRepository.findById(idAccountNumber).get().getBalance();
    }


    public void deleteAccount(Long id) {

        if (accountRepository.findById(id).isPresent()) {

            accountRepository.delete(accountRepository.findById(id).get());

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID doesn't match any of the accounts in our system");
        }

    }
}
