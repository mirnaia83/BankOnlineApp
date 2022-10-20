package com.example.BankOnlineApp.entities.account;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.user.AccountHolder;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class CreditCard extends Account {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "credit_limit_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "creadit_limit_amount"))})
    @Min(100)
    @Max(100000)
    public Money creditLimit;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "interest_rate_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "interest_rate_amount"))})
    @DecimalMin(value = "0.1")
   private Money interestRate = new Money(BigDecimal.valueOf(0.2));

    private LocalDate lastInterestDay;

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

    public  void interestRate(){
        if(Period.between(lastInterestDay, LocalDate.now()).getMonths() >= 1){
            BigDecimal bigDecimal = getBalance().getAmount().multiply(interestRate.getAmount());
            setBalance(new Money(getBalance().increaseAmount(bigDecimal)));
        }
    }

}
