package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.account.Account;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByPrimaryOwner(AccountHolder accountHolder);

    List<Account> findBySecondaryOwner(AccountHolder accountHolder);


}
