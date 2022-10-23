package com.example.BankOnlineApp.entities.user;
import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.Address;
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

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public List<Account> getPrimaryAccountHolderList() {
        return primaryAccountHolderList;
    }

    public void setPrimaryAccountHolderList(List<Account> primaryAccountHolderList) {
        this.primaryAccountHolderList = primaryAccountHolderList;
    }

    public List<Account> getSecondaryAccountHolderList() {
        return secondaryAccountHolderList;
    }

    public void setSecondaryAccountHolderList(List<Account> secondaryAccountHolderList) {
        this.secondaryAccountHolderList = secondaryAccountHolderList;
    }

    public List<Transaction> getSentTransactionList() {
        return sentTransactionList;
    }

    public void setSentTransactionList(List<Transaction> sentTransactionList) {
        this.sentTransactionList = sentTransactionList;
    }

    public List<Transaction> getReceiveTransactionList() {
        return receiveTransactionList;
    }

    public void setReceiveTransactionList(List<Transaction> receiveTransactionList) {
        this.receiveTransactionList = receiveTransactionList;
    }
}
