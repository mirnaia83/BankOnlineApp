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

    @NotNull
    @JsonFormat (pattern = "DD-MM-YYYY")
    private LocalDate dateOfBirth;
    @Embedded
    @NotNull
    private Address primaryAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "SECONDARY_NAME")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "SECONDARY_POSTAL_CODE")),
            @AttributeOverride(name = "city", column = @Column(name = "SECONDARY_CITY")),
            @AttributeOverride(name = "country", column = @Column(name = "SECONDARY_COUNTRY"))
    })
    private Address secondaryAddress;

    @OneToMany (mappedBy = "primaryOwner")
    private List<Account> primaryAccountList = new ArrayList<>();

    @OneToMany (mappedBy = "secondaryOwner")
    private List<Account> sndAccountList = new ArrayList<>();


    @OneToMany (mappedBy = "moneySender")
    private List<Transaction> sentTransferenceList = new ArrayList<>();

    @OneToMany (mappedBy = "moneyReceiver")
    private List<Transaction> receiveTransferenceList = new ArrayList<>();


    public AccountHolder(String username, String password, LocalDate dateOfBirth, Address primaryAddress, Address secondaryAddress) {
        super(username, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.secondaryAddress = secondaryAddress;
    }

    public AccountHolder() {

    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public Address getSecondaryAddress() {
        return secondaryAddress;
    }

    public List<Account> getPrimaryAccountList() {
        return primaryAccountList;
    }

    public List<Account> getSndAccountList() {
        return sndAccountList;
    }

    public List<Transaction> getSentTransferenceList() {
        return sentTransferenceList;
    }

    public List<Transaction> getReceiveTransferenceList() {
        return receiveTransferenceList;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public void setSecondaryAddress(Address secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
    }

    public void setPrimaryAccountList(List<Account> primaryAccountList) {
        this.primaryAccountList = primaryAccountList;
    }

    public void setSndAccountList(List<Account> sndAccountList) {
        this.sndAccountList = sndAccountList;
    }

    public void setSentTransferenceList(Transaction transaction) {
        this.sentTransferenceList.add(transaction);
    }

    public void setReceiveTransferenceList(List<Transaction> receiveTransferenceList) {
        this.receiveTransferenceList = receiveTransferenceList;
    }
}