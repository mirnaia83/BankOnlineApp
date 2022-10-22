package com.example.BankOnlineApp.DTO;

import com.example.BankOnlineApp.entities.user.AccountHolder;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

public class AccountDTO {
    @NotNull
    private BigDecimal balance;

    private Currency currency;

    @NotNull
    private String secretKey;

    private AccountHolder secondaryOwner;

    private BigDecimal minimumBalance;

    private LocalDate creationDate;

    private BigDecimal interestRate;

    private BigDecimal creditLimit;

    public AccountDTO(BigDecimal balance, Currency currency, String secretKey,
                      AccountHolder secondaryOwner, BigDecimal minimumBalance,
                      LocalDate creationDate, BigDecimal interestRate,
                      BigDecimal creditLimit) {
        this.balance = balance;
        this.currency = currency;
        this.secretKey = secretKey;
        this.secondaryOwner = secondaryOwner;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Long getPrimaryOwnerId() {
    }

    public Long getSecondaryOwnerId() {
    }

    public char[] getMonthlyMaintenanceFee() {
    }

    public char[] getPenaltyFee() {
    }
}

