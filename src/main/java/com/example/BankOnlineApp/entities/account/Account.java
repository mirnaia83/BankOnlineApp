package com.example.BankOnlineApp.entities.account;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
import com.example.BankOnlineApp.entities.user.AccountHolder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccountNumber;
    @Embedded
    private Money balance;

    @ManyToOne
    @JoinColumn(name = "primary_owner_user_id")
    private AccountHolder primaryOwner;

    @ManyToOne
    @JoinColumn(name = "secondary_owner_user_id")
    private AccountHolder secondaryOwner;

    public String owner;
   // private Long secretKey;
    @Max(40)
    private final BigDecimal penaltyFee = BigDecimal.valueOf(40);

    private LocalDate creationDate;
    private EnumerationStatus enumerationStatus;


    public Account( Money balance, AccountHolder primaryOwner,
                   AccountHolder secondaryOwner) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        //this.secretKey = secretKey;
        this.creationDate = LocalDate.now();
        this.enumerationStatus = EnumerationStatus.ACTIVE;

    }

    public Account() {
    }



    public Long getIdAccountNumber() {
        return idAccountNumber;
    }

    public void setIdAccountNumber(Long idAccountNumber) {
        this.idAccountNumber = idAccountNumber;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public EnumerationStatus getEnumerationStatus() {
        return enumerationStatus;
    }

    public void setEnumerationStatus(EnumerationStatus enumerationStatus) {
        this.enumerationStatus = enumerationStatus;
    }

    public void checkInterestRate() {
    }
}
