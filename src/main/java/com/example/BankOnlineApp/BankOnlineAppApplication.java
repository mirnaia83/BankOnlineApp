package com.example.BankOnlineApp;

import com.example.BankOnlineApp.entities.Address;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.entities.user.Admin;
import com.example.BankOnlineApp.entities.user.Role;
import com.example.BankOnlineApp.entities.user.ThirdPartyUser;
import com.example.BankOnlineApp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class BankOnlineAppApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AccountHolderRepository accountHolderRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ThirdPartyUserRepository thirdPartyUserRepository;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


	public static void main(String[] args) {
		SpringApplication.run(BankOnlineAppApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		adminRepository.deleteAll();
		roleRepository.deleteAll();
		thirdPartyUserRepository.deleteAll();
		accountHolderRepository.deleteAll();


		Address address1 = new Address("Calle x", 654812, "España");
		LocalDate dob = LocalDate.of(2020, 9, 11);

		AccountHolder accountHolder = new AccountHolder("Nas", passwordEncoder.encode("4444"), dob, address1, null);
		accountHolder.addRole(new Role("ACCOUNT_HOLDER", accountHolder));

		Admin admin = adminRepository.save(new Admin("Oskar", passwordEncoder.encode("1234")));
		admin.addRole(new Role("ADMIN", admin));
		adminRepository.save(admin);

		ThirdPartyUser thirdPartyUser = new ThirdPartyUser("Anya", passwordEncoder.encode("password"), "AB234102");
		thirdPartyUser.addRole(new Role("THIRD_PARTY", thirdPartyUser));
		thirdPartyUserRepository.save(thirdPartyUser);


	}
}
