package com.example.BankOnlineApp.services;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.account.CreditCard;
import com.example.BankOnlineApp.entities.account.Savings;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.repositories.AccountRepository;
import com.example.BankOnlineApp.services.serviceInterfaces.AccountHolderServiceInterface;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public abstract class AccountHolderService implements AccountHolderServiceInterface {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    AccountRepository accountRepository;

    //register new accountHolder
    public AccountHolder registerAccountHolder(AccountHolder accountHolder){
        return accountHolderRepository.save(accountHolder);
    }

public List<Account> getAccountHolderAccount(Long userId){
        AccountHolder accountHolder = accountHolderRepository.findById(userId).get();
        List<Account> accountHolderList = accountRepository.findByPrimaryOwner(accountHolder);
        List<Account> accountHolderList1 = accountRepository.findBySecondaryOwner(accountHolder);
        accountHolderList.addAll(accountHolderList1);
        return accountHolderList;
}

    //access balance
public BigDecimal getBalance(Long idAccountNumber){
    Account account = accountRepository.findById(idAccountNumber).get();
    if(account instanceof CreditCard){
        ((CreditCard) account).getInterestRate();
    } else if(account instanceof Savings){
        ((Savings) account).checkInterestRate();
    }

    return account.getBalance().getAmount();
}

public String transferBalanceAccountHolder(Long idAccountNumber, String name, BigDecimal amount, Long idAccountNumber2){
        Account account = accountRepository.findById(idAccountNumber).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sender doesn't exist"));
        Account account1 = accountRepository.findById(idAccountNumber2).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receiver doesn't find"));

        account.setBalance(new Money(account.getBalance().decreaseAmount(amount)));
        account1.setBalance(new Money(account1.getBalance().increaseAmount(amount)));

        accountRepository.save(account);
        accountRepository.save(account1);

        String transfer = account.getPrimaryOwner().getUsername() + "has sent" + amount + "to" + account1.getPrimaryOwner().getUsername();
        return transfer;
    }
}

