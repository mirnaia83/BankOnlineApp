package com.example.BankOnlineApp.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {
@NotNull
   private String address;
@NotNull
@Digits(integer = 6, fraction = 0)
    private Integer postalCode;
@NotNull
    private String country;

    public Address() {
    }

    public Address(String address, Integer postalCode, String country) {
        this.address = address;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
