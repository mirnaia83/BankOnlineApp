package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.account.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long > {

}
