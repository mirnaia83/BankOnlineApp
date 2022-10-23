package com.example.BankOnlineApp.entities;

import com.example.BankOnlineApp.entities.enums.CurrencyValue;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Embeddable
public class Money {

    private static final Currency EUR = Currency.getInstance("EUR");
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;

    private static CurrencyValue defaultCurrencyValue = CurrencyValue.EURO;
    @NotNull
    private CurrencyValue currencyValue;

    @NotNull
    @Column(precision = 19, scale = 4)
    private BigDecimal amount;

    public Money(Currency currency, BigDecimal balance) {

    }

    public Money(CurrencyValue currencyValue) {
        this.currencyValue = currencyValue;
    }


    public Money(CurrencyValue currencyValue, BigDecimal amount) {
        setCurrencyValue(currencyValue);
        this.amount = amount;
    }

    private void setCurrencyValue(CurrencyValue currencyValue) {

    }

    public Money(BigDecimal amount) {
        this.amount = amount;
        this.currencyValue = defaultCurrencyValue;
    }


    public BigDecimal increaseAmount(BigDecimal addAmount) {
        setAmount(this.amount.add(addAmount));
        return this.amount;
    }

    public BigDecimal decreaseAmount(BigDecimal addAmount) {
        setAmount(this.amount.subtract(addAmount));
        return this.amount;
    }

    public CurrencyValue getCurrencyValue() {
        return this.currencyValue;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String toString() {
        return getCurrencyValue().getSymbol() + " " + getAmount();
    }

    public void setCurrency(CurrencyValue currencyValue) {
        if (currencyValue == null) {
            this.currencyValue = defaultCurrencyValue;
        } else {
            this.currencyValue = currencyValue;
        }

    }

    public BigDecimal moneyConversionEur() {
    return null;}

    public void conversionToAccount() {
    }
}