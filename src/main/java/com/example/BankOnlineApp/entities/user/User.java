package com.example.BankOnlineApp.entities.user;

import com.example.BankOnlineApp.entities.Money;
import com.example.BankOnlineApp.entities.enums.EnumerationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

  @Column(nullable = false)
   private String password;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    @JsonIgnore
//    private List<Role> roles;


    public User(Money balance, String username, String password, int penaltyFee, LocalDate creationDate, EnumerationStatus enumerationStatus) {
        this.username = username;
        this.password = password;
    }
}