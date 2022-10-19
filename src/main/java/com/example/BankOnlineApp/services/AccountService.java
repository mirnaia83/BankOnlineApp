package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.DTO.AccountDTO;
import com.example.BankOnlineApp.entities.account.*;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.AccountServiceInterface;
import com.example.BankOnlineApp.repositories.AccountRepository;
import org.hibernate.type.LocalDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        BigDecimal balanceBigDecimal = new BigDecimal(accountDTO.getBalance());
        Money balance = new Money(balanceBigDecimal);
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = accountHolderRepository.findById(accountDTO.getSecondaryOwnerId()).get();
        Money creditLimit = new Money(new BigDecimal(accountDTO.getCreditLimit()));
        Money interestRate = new Money(new BigDecimal(accountDTO.getInterestRate()));

        CreditCard creditCard = new CreditCard(balance, primaryOwner, secondaryOwner, creditLimit, interestRate);

        return accountRepository.save(creditCard);
    }

    public Savings createSavings(AccountDTO accountDTO){
        BigDecimal balanceBigDecimal = new BigDecimal(accountDTO.getBalance());
        Money balance = new Money(balanceBigDecimal);
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = accountHolderRepository.findById(accountDTO.getSecondaryOwnerId()).get();
        Money interestRate = new Money(new BigDecimal(accountDTO.getInterestRate()));
        BigDecimal minimumBalanceBigDecimal = new BigDecimal(accountDTO.getMinimumBalance());
        Money minimumBalance = new Money(minimumBalanceBigDecimal);

        Savings savings = new Savings(balance, primaryOwner, secondaryOwner, interestRate, minimumBalance, LocalDate.now());

        return  accountRepository.save(savings);
    }

    public CheckingAccount createCheckingAccount(AccountDTO accountDTO){
        BigDecimal balanceBigDecimal = new BigDecimal(accountDTO.getBalance());
        Money balance = new Money(balanceBigDecimal);
        AccountHolder primaryOwner = accountHolderRepository.findById(accountDTO.getPrimaryOwnerId()).get();
        AccountHolder secondaryOwner = accountHolderRepository.findById(accountDTO.getSecondaryOwnerId()).get();
        BigDecimal minimumBalanceBigDecimal = new BigDecimal(accountDTO.getMinimumBalance());
        Money minimumBalance = new Money(minimumBalanceBigDecimal);
        Money penaltyFee = new Money(new BigDecimal(accountDTO.getPenaltyFee()));
        Money monthlyMaintenanceFee = new Money(new BigDecimal(accountDTO.getMonthlyMaintenanceFee()));

        if( Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears() >= 24  ){
            CheckingAccount checkingAccount = new CheckingAccount(balance, primaryOwner, secondaryOwner, minimumBalance, penaltyFee,
                    monthlyMaintenanceFee, LocalDate.now(), EnumerationStatus.ACTIVE);
        } else {
            StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount(balance, primaryOwner, secondaryOwner, minimumBalance, penaltyFee,
                    monthlyMaintenanceFee, LocalDate.now(), EnumerationStatus.ACTIVE);}
        return  accountRepository.save(new CheckingAccount());


    }



    public Money getBalance(Long idAccountNumber) {
        return accountRepository.findById(idAccountNumber).get().getBalance();
    }



}
