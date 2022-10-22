package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.user.ThirdPartyUser;
import com.example.BankOnlineApp.repositories.AccountRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.ThirdPartyUserServiceInterface;
import com.example.BankOnlineApp.repositories.ThirdPartyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ThirdPartyUserService implements ThirdPartyUserServiceInterface {

    @Autowired
    ThirdPartyUserRepository thirdPartyUserRepository;

    @Autowired
    AccountRepository accountRepository;

    public Money transfer(Long idAccountNumber, BigDecimal amount, Long idAccountNumber2, String hashedKey){
        Account account = accountRepository.findById(idAccountNumber).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "account is not found"));
        if(!thirdPartyUserRepository.findByHashedKey(hashedKey))
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "is not available");
        Account account1 = accountRepository.findById(idAccountNumber2).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "account is not found"));
        if(account.getBalance().getAmount().compareTo(amount)<0) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Not enough funds");
        account.setBalance(new Money(account.getBalance().decreaseAmount(amount)));
        account1.setBalance(new Money(account1.getBalance().increaseAmount(amount)));
        accountRepository.saveAll(List.of(account, account1));
        return account.getBalance();
        }

    public void createThirdPartyUser(ThirdPartyUser thirdPartyUser) {
    }
}



