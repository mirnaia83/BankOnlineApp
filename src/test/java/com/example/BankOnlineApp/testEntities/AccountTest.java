package com.example.BankOnlineApp.testEntities;

import com.example.BankOnlineApp.entities.Address;
import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.account.Savings;
import com.example.BankOnlineApp.entities.user.AccountHolder;
import com.example.BankOnlineApp.entities.user.Role;
import com.example.BankOnlineApp.repositories.AccountHolderRepository;
import com.example.BankOnlineApp.repositories.AccountRepository;
import com.example.BankOnlineApp.repositories.RoleRepository;
import com.example.BankOnlineApp.repositories.SavingsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AccountTest {
    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    PasswordEncoder passwordEncoder;

    private MockMvc mockMvc;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    SavingsRepository savingsRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        objectMapper.findAndRegisterModules();

        LocalDate dob = LocalDate.of(2020, 7, 15);
        Address address = new Address("Ronda de Subira", 1234, "Reus", "España");
        AccountHolder accountHolder = new AccountHolder("Irina", passwordEncoder.encode("2222"), dob, address, null);
        Role accountHolderRole = new Role("ACCOUNT_HOLDER", accountHolder);

        Money money = new Money(new BigDecimal(200.00));
        Money minimumBal = new Money(new BigDecimal(150.00));
        BigDecimal interest = new BigDecimal(0.3);

        Savings savings = new Savings(money, "AB23192684", accountHolder, new AccountHolder(), minimumBal, LocalDate.now(), interest);
        savings.setId(15L);

        savingsRepository.save(savings);
        accountHolderRepository.save(accountHolder);
        roleRepository.save(accountHolderRole);

    }

    @AfterEach
    void tearDown() {
        roleRepository.deleteAll();
        accountHolderRepository.deleteAll();
    }

    @Test
    void createAccountOk() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/create/{accountType}/{id}", "checking", "Nas").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();
    }

    void createAccountError() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/create/{accountType}/{id}", "checking").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound()).andReturn();
        assertTrue(mvcResult.getResolvedException().getMessage().contains("An AccountHolder with this ID doesn't exits in the database"));
    }

    @Test
    void deleteAccountOk() throws Exception {

        MvcResult mvcResult = mockMvc.perform(delete("/delete/account?id=15")).andExpect(status().isOk()).andReturn();

        boolean found = savingsRepository.findById(15L).isPresent();
        assertFalse(found);

    }
}

