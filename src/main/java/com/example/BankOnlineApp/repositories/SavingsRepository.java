package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Money> {

    //defaultInterestRate(0.0025)
    //maxIntrRate(0.5)
    //defaultMinBalance(1000)
    //minBalance(100)
    //addInterest(0.1 annualy)



}
