package com.example.BankOnlineApp.entities.user;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;

import javax.persistence.Entity;
import java.security.Key;
import java.time.LocalDate;

@Entity
public class ThirdPartyUser extends User {

    private String secretKey;


    public ThirdPartyUser() {
    }

    public ThirdPartyUser(String username, String password, String hashedKey) {
        super(username, password);
        this.secretKey = secretKey;
    }

    public String getHashedKey() {
        return secretKey;
    }

    public void setHashedKey(String hashedKey) {
        this.secretKey = hashedKey;
    }
}
