package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.account.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long > {

    //defaultCreditLimit(100)
    // maxCreditLimit(100000)
    //defIntrate(0.2)
    //minIntrate(0.1)
    //addInterest(interestMensual)
}
