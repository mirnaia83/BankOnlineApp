package com.example.BankOnlineApp.entities.user;



import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Admin extends User {


    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin(){

    };

}
