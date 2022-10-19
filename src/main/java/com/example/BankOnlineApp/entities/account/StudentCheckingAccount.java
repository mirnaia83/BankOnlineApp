package com.example.BankOnlineApp.entities.account;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
import com.example.BankOnlineApp.entities.user.AccountHolder;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class StudentCheckingAccount extends Account {

    public StudentCheckingAccount(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money minimumBalance, Money penaltyFee, Money monthlyMaintenanceFee, LocalDate now, EnumerationStatus active) {
    }

    public StudentCheckingAccount(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        super(balance, primaryOwner, secondaryOwner);
    }

}



