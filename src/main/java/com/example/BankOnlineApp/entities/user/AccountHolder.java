package com.example.BankOnlineApp.entities.user;
import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.Address;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AccountHolder extends User {

    private String username;
    private String mail;
    @NotNull
    @JsonFormat(pattern = "DD-MM-YYYY")
    private LocalDate dateOfBirth;
    private String phone;
    private String password;



    @Embedded
    @NotNull
    private Address primaryAddress;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "mailingAddress")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailingPostalCode")),
            @AttributeOverride(name = "country", column = @Column(name = "mailingCountry"))})
    private Address mailingAddress;

    @OneToMany(mappedBy = "primaryOwner")
    @JsonIgnore
    private List<Account> primaryAccountHolderList;


    @OneToMany(mappedBy = "secondaryOwner")
    @JsonIgnore
    private List<Account> secondaryAccountHolderList;

    @OneToMany(mappedBy = "moneySender")
    private List<Transaction> sentTransactionList = new ArrayList<>();

    @OneToMany(mappedBy = "moneyReceiver")
    private List<Transaction> receiveTransactionList = new ArrayList<>();

    public AccountHolder(){

    }

    public AccountHolder(String username, String password, LocalDate dateOfBirth,
                         Address primaryAddress, Address secondaryAddress) {
        super(username, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public List<Account> getPrimaryAccountHolderList() {
        return primaryAccountHolderList;
    }

    public List<Account> getSecondaryAccountHolderList() {
        return secondaryAccountHolderList;
    }

    public List<Transaction> getSentTransactionList() {
        return secondaryAccountHolderList;
    }

    public List<Transaction> getReceiveTransactionList() {
        return receiveTransactionList;
    }

    //setters
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public void setPrimaryAccountHolderList(List<Account> primaryAccountHolderList) {
        this.primaryAccountHolderList = primaryAccountHolderList;
    }

    public void setSecondaryAccountHolderList(List<Account> secondaryAccountHolderList) {
        this.secondaryAccountHolderList = secondaryAccountHolderList;
    }

    public void setSentTransactionList(Transaction transaction) {
        this.sentTransactionList.add(transaction);
    }

    public void setReceiveTransactionList(List<Transaction> receiveTransactionList) {
        this.receiveTransactionList = receiveTransactionList;
    }
}
