package com.example.BankOnlineApp;

import com.example.BankOnlineApp.entities.Address;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import com.example.BankOnlineApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BankOnlineAppApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AccountHolderRepository accountHolderRepository;


	public static void main(String[] args) {
		SpringApplication.run(BankOnlineAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Address address1 = new Address("Calle x", 654812, "España");

		AccountHolder accountHolder1 = new AccountHolder("Irina", "irina@gmail.com", LocalDate.of(2000,1,1), 654654, "password", address1);
		accountHolderRepository.save(accountHolder1);

	}
}
