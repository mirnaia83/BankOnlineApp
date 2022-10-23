package com.example.BankOnlineApp.testRepository;

import com.example.BankOnlineApp.entities.user.ThirdPartyUser;
import com.example.BankOnlineApp.repositories.ThirdPartyUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RepositoryTest{
    @Autowired
    ThirdPartyUserRepository thirdPartyUserRepository;

    @BeforeEach
    void buildUp() {
        ThirdPartyUser thirdPartyUser = new ThirdPartyUser("Monica", "pasword", "123B-A23C");
        thirdPartyUserRepository.save(thirdPartyUser);
    }

    @AfterEach
    void tearDown() {
        thirdPartyUserRepository.deleteAll();
    }

    @Test
    void findThirdPartyUserBySecretKey() {
        ThirdPartyUser thirdPartyUser = thirdPartyUserRepository.findBySecretKey("123B-A23C").get();

        assertEquals(thirdPartyUser.getSecretKey(), "123B-A23C");

    }
}