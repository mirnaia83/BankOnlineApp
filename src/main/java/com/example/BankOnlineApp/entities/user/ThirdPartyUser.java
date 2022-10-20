package com.example.BankOnlineApp.entities.user;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;

import javax.persistence.Entity;
import java.security.Key;
import java.time.LocalDate;

@Entity
public class ThirdPartyUser extends User {

    private String hashedKey;
    private String name;

    public ThirdPartyUser() {
    }

    public ThirdPartyUser(Money balance, String username, String password, int penaltyFee,
                         LocalDate creationDate, EnumerationStatus enumerationStatus, String hashedKey, String name) {
        super(balance, username, password, penaltyFee, creationDate, enumerationStatus);
        this.hashedKey = hashedKey;
        this.name = name;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
