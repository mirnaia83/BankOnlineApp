package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.account.StudentCheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingAccountRepository extends JpaRepository<StudentCheckingAccount, Long> {
}
