package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.controllers.controllerInterfaces.AdminControllerInterface;
import com.example.BankOnlineApp.services.AdminService;
import com.example.BankOnlineApp.services.serviceInterfaces.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AdminController implements AdminControllerInterface {

    @Autowired
    AdminService adminService;
    @PatchMapping("/modifyBalance/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public void modifyBalance(@PathVariable BigDecimal amount , @RequestParam Long id) {

        adminService.modifyBalance(id, amount);

    }

    @PatchMapping("/FreezeAccount/")
    @ResponseStatus(HttpStatus.OK)
    public void freezeAccount(@RequestParam Long id) {
        adminService.freezeAccount(id);
    }
}
