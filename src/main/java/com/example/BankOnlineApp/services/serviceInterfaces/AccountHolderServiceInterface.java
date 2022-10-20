package com.example.BankOnlineApp.services.serviceInterfaces;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.user.AccountHolder;

import java.math.BigDecimal;
import java.util.List;

public interface AccountHolderServiceInterface {

    List<AccountHolder> showHolderAccount();
    AccountHolder registerAccountHolder(AccountHolder accountHolder);
BigDecimal getBalance(Long idAccountNumber);
Money transferMoney(Long idAccountNumber, BigDecimal amount, Long idAccountNumber1);


}
