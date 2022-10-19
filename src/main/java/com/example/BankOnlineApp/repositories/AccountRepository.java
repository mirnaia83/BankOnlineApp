package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
//    Money findBalanceBy(Long idAccountNumber);

    //transfer()
    //Check balance()
    //Receive funds()
    //Query DetectateFraud

}
