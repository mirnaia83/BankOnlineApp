package com.example.BankOnlineApp.repositories;

import com.example.BankOnlineApp.entities.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

}
