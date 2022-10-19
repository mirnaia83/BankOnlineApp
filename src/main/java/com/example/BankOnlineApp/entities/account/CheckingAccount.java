package com.example.BankOnlineApp.entities.account;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.user.AccountHolder;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
public class CheckingAccount extends Account {
    @Min(250)
    @Max(99999)
    private Double minimumBalance;

   // private LocalDate lastInterestDay;
    private Double monthlyMaintenanceFee;


    public CheckingAccount() {
    }

    public CheckingAccount(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Double minimumBalance, Double monthlyMaintenanceFee) {
        super(balance, primaryOwner, secondaryOwner);
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
//
//    public LocalDate getLastInterestDay() {
//        return lastInterestDay;
//    }
//
//    public void setLastInterestDay(LocalDate lastInterestDay) {
//        this.lastInterestDay = lastInterestDay;
//    }

    public Double getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Double monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }
}
