package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.DTO.AccountDTO;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.CheckingAccount;
import com.example.BankOnlineApp.entities.account.StudentCheckingAccount;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import com.example.BankOnlineApp.repositories.StudentCheckingAccountRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.CheckingAccountServiceInterface;
import com.example.BankOnlineApp.repositories.CheckingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class CheckingAccountService {

    @Autowired
    CheckingAccountRepository checkingAccountRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    StudentCheckingAccountRepository studentCheckingAccountRepository;

    public void createChecking(AccountDTO accountDTO, String id) {
        if (accountHolderRepository.findById(id).isPresent()) {

            LocalDate today = LocalDate.now();

            Money money = new Money(accountDTO.getCurrency(), accountDTO.getBalance());
            String secretKey = accountDTO.getSecretKey();
            AccountHolder owner = (AccountHolder) accountHolderRepository.findById(id).get();
            AccountHolder secondaryOwner = accountDTO.getSecondaryOwner();
            Money minimumBalance = new Money(accountDTO.getMinimumBalance());
            LocalDate creationDate;
            if (accountDTO.getCreationDate() != null) {
                creationDate = accountDTO.getCreationDate();
            } else {
                creationDate = today;}

            if (accountHolderRepository.findById(id).get().

                    //isAfter(today.minusYears(24))) {

                StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount(money, secretKey, owner, secondaryOwner, creationDate);

                studentCheckingAccountRepository.save(studentCheckingAccount);

            } else {

                CheckingAccount checkingAccount = new CheckingAccount(money, secretKey, owner, secondaryOwner, creationDate);
                if (minimumBalance.getAmount() != null) {
                    checkingAccount.getMoney().setAmount(minimumBalance.getAmount());
                }

                checkingAccountRepository.save(checkingAccount);
            }

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "An AccountHolder with this ID doesn't exits in the database");
        }
    }
}

