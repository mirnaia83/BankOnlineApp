package com.example.BankOnlineApp.entities.account;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.user.AccountHolder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;



@Entity
public class Savings extends Account {
    public static final String secretKey = "1234";
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance_amount"))})
    private Money minimumBalance;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "interest_rate_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "interest_rate_amount"))})
    private Money interestRate;
    private LocalDate lastInterestDay;


    public Savings() {
    }

    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                   Money minimumBalance, Money interestRate, LocalDate lastInterestDay) {
        super(balance, secretKey, primaryOwner, secondaryOwner);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
        this.lastInterestDay = lastInterestDay;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Money getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Money interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getLastInterestDay() {
        return lastInterestDay;
    }

    public void setLastInterestDay(LocalDate lastInterestDay) {
        this.lastInterestDay = lastInterestDay;
    }

    @Override
    public void setBalance(Money balance){
        if(minimumBalance == null){
            minimumBalance = new Money(BigDecimal.valueOf(1000));
        }
        super.setBalance(balance);
        if(minimumBalance.getAmount().compareTo(balance.getAmount())>0)
            super.setBalance(new Money(super.getBalance().decreaseAmount(super.getPenaltyFee())));
    }

    public void checkInterestRate(){
        if(Period.between(lastInterestDay, LocalDate.now()).getYears()>=1){
            BigDecimal bigDecimal = getBalance().getAmount().multiply(interestRate.getAmount());
            setBalance(new Money(getBalance().increaseAmount(bigDecimal)));
        }
    }

    public void setSecretKey(String secretKey) {
    }

    public void setPrimaryOwner(Object o) {
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
    }

    public void setId(long l) {
    }

    public void setEnumerationStatus() {
    }
}
