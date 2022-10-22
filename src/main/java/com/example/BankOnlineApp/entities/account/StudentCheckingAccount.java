package com.example.BankOnlineApp.entities.account;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class StudentCheckingAccount extends Account {
    @NotNull
    @JsonFormat(pattern = "DD-MM-YYYY")
    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    private EnumerationStatus enumerationStatus = EnumerationStatus.ACTIVE;

    public StudentCheckingAccount(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money minimumBalance, Money penaltyFee, Money monthlyMaintenanceFee, LocalDate now, EnumerationStatus active) {
    }

    public StudentCheckingAccount(Money money, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, LocalDate creationDate) {
        super(money, secretKey, primaryOwner, secondaryOwner);
        this.creationDate = creationDate;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public EnumerationStatus getEnumerationStatus() {
        return enumerationStatus;
    }

    @Override
    public void setEnumerationStatus(EnumerationStatus enumerationStatus) {
        this.enumerationStatus = enumerationStatus;
    }
}



