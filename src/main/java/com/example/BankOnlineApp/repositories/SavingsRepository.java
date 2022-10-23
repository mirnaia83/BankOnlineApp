package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {

}
