package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.user.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
//    Long findBalanceById(Long id);
//
//    void withdrawAmountById(Long id, int amount);
//
//    void saveBalanceById(Long destinationAcctId, int amount);
    //register
    // login
    //accessBalance
    //transferBalance
}
