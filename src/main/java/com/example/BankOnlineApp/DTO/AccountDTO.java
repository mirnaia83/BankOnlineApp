package com.example.BankOnlineApp.DTO;

public class AccountDTO {
    private String balance;
    private Long primaryOwnerId;
    private Long secondaryOwnerId;
    private String creditLimit;
    private String interestRate;
    private String minimumBalance;
    private String lastInterestDay;

    public AccountDTO(String balance, Long primaryOwnerId, Long secondaryOwnerId, String creditLimit, String interestRate, String minimumBalance,
                      String lastInterestDay) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
        this.lastInterestDay = lastInterestDay;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Long getPrimaryOwnerId() {
        return primaryOwnerId;
    }

    public void setPrimaryOwnerId(Long primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    public Long getSecondaryOwnerId() {
        return secondaryOwnerId;
    }

    public void setSecondaryOwnerId(Long secondaryOwnerId) {
        this.secondaryOwnerId = secondaryOwnerId;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(String minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public String getLastInterestDay() {
        return lastInterestDay;
    }

    public void setLastInterestDay(String lastInterestDay) {
        this.lastInterestDay = lastInterestDay;
    }
}
