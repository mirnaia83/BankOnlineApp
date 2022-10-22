package com.example.BankOnlineApp.entities;

import com.example.BankOnlineApp.entities.user.AccountHolder;

import javax.persistence.*;
import java.time.LocalDate;

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "sentTransactionList")
    AccountHolder moneySender;

    @ManyToOne
    @JoinColumn(name = "receiveTransferenceList")
    AccountHolder moneyReceiver;

    private final LocalDate transactionDate = LocalDate.now();

    public Transaction() {

    }

    public Transaction(AccountHolder moneySender, AccountHolder moneyReceiver) {

        this.moneySender = moneySender;
        this.moneyReceiver = moneyReceiver;
    }

    public Long getId() {
        return id;
    }

    public AccountHolder getMoneySender() {
        return moneySender;
    }

    public void setMoneySender(AccountHolder moneySender) {
        this.moneySender = moneySender;
    }

    public AccountHolder getMoneyReceiver() {
        return moneyReceiver;
    }

    public void setMoneyReceiver(AccountHolder moneyReceiver) {
        this.moneyReceiver = moneyReceiver;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}