package com.example.BankOnlineApp.entities.user;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Admin extends User {

    private String roles;

    public Admin(Money balance, String username, String password, int penaltyFee, LocalDate creationDate, EnumerationStatus enumerationStatus, String roles) {
        super(balance, username, password, penaltyFee, creationDate, enumerationStatus);
        this.roles = roles;
    }

    public Admin() {
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
