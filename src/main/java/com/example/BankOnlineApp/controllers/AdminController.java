package com.example.BankOnlineApp.controllers;

import com.example.BankOnlineApp.controllers.controllerInterfaces.AdminControllerInterface;
import com.example.BankOnlineApp.services.serviceInterfaces.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController implements AdminControllerInterface {

    @Autowired
    AdminServiceInterface adminService;


}
