package com.example.BankOnlineApp.entities.account;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
import com.example.BankOnlineApp.entities.user.AccountHolder;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
public class CheckingAccount extends Account {
    @Min(250)
    @Max(99999)
    private Money minimumBalance;

   // private LocalDate lastInterestDay;
    private Money monthlyMaintenanceFee;

    public CheckingAccount(){


    }
    public CheckingAccount(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money minimumBalance, Money penaltyFee, Money monthlyMaintenanceFee, LocalDate now, EnumerationStatus active) {
    }

    public CheckingAccount(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money minimumBalance, Money monthlyMaintenanceFee) {
        super(balance, primaryOwner, secondaryOwner);
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Money monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}
