package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.CheckingAccount;
import com.example.BankOnlineApp.entities.account.Savings;
import com.example.BankOnlineApp.entities.account.StudentCheckingAccount;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
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

        if (accountRepository.findById(id).isPresent()) {
            Account account = accountRepository.findById(id).get();

            account.getMoney().setAmount(amount);
            accountRepository.save(account);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The ID introduced doesn't match any Accounts in our systems.");
        }

    }

    public void freezeAccount(Long id) {
        if (accountRepository.findById(id).isPresent()) {

            Account account = accountRepository.findById(id).get();

            if (account.getClass().equals(Savings.class)) {
                ((Savings) account).setEnumerationStatus(EnumerationStatus.FROZEN);

            } else if (account.getClass().equals(StudentCheckingAccount.class)) {
                ((StudentCheckingAccount) account).setEnumerationStatus(EnumerationStatus.FROZEN);
            } else if (account.getClass().equals(CheckingAccount.class)) {
                ((CheckingAccount) account).setEnumerationStatus(EnumerationStatus.FROZEN);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't Freeze a CreditCard Account type.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with the introduced ID not found.");
        }
    }
}






