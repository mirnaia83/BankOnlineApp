package com.example.BankOnlineApp.entities.account;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.user.AccountHolder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CreditCard extends Account {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "credit_limit_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "creadit_limit_amount"))})
    public Money creditLimit;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "interest_rate_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "interest_rate_amount"))})
    public Money interestRate;
    //private LocalDate lastInterestDay;

    public CreditCard() {
    }

    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money creditLimit, Money interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;

    }

    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Money getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Money interestRate) {
        this.interestRate = interestRate;
    }

//    public LocalDate getLastInterestDay() {
//        return lastInterestDay;
//    }
//
//    public void setLastInterestDay(LocalDate lastInterestDay) {
//        this.lastInterestDay = lastInterestDay;
//    }
}
