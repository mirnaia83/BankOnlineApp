package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.account.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {

//24 years or more


}
