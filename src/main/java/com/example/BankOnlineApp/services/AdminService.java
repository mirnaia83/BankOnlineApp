package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import com.example.BankOnlineApp.repositories.AccountRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.AdminServiceInterface;
import com.example.BankOnlineApp.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class AdminService implements AdminServiceInterface {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    AccountRepository accountRepository;

    public Money getBalanceAsAdmin(Long accountNumber){
        return accountRepository.findById(accountNumber).get().getBalance();
    }

    public Money addBalanceAsAdmin(Long accountNumber, BigDecimal amount){
        Account account = accountRepository.findById(accountNumber).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "account number not found"));
                account.setBalance(new Money(account.getBalance().increaseAmount(amount)));
                accountRepository.save(account);
                return account.getBalance();

    }


    public void modifyBalance(Long id, BigDecimal amount) {
    }

    public void freezeAccount(Long id) {
    }
}






