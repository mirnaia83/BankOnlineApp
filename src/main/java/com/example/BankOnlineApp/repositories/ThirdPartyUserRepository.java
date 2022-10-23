package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.user.ThirdPartyUser;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThirdPartyUserRepository extends JpaRepository<ThirdPartyUser, String> {
    boolean findByHashedKey(String hashedKey);

    MutablePropertyValues findBySecretKey(String s);
}
