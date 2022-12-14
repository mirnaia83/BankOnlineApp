package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.user.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

    Optional<Object> findById(String id);

    LocalDate getDateOfBirth(LocalDate localDate);


}
