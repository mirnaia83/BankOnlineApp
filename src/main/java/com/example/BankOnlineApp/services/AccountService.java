package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.DTO.AccountDTO;
import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.CreditCard;
import com.example.BankOnlineApp.entities.account.Savings;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.AccountServiceInterface;
import com.example.BankOnlineApp.repositories.AccountRepository;
import org.hibernate.type.LocalDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

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





    public Money getBalance(Long idAccountNumber) {
        return accountRepository.findById(idAccountNumber).get().getBalance();
    }



}
