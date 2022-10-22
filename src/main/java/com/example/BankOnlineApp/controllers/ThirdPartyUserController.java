package com.example.BankOnlineApp.controllers;
import com.example.BankOnlineApp.controllers.controllerInterfaces.ThirdPartyUserControllerInterface;
import com.example.BankOnlineApp.entities.user.ThirdPartyUser;
import com.example.BankOnlineApp.services.ThirdPartyUserService;
import com.example.BankOnlineApp.services.serviceInterfaces.ThirdPartyUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyUserController implements ThirdPartyUserControllerInterface {

    @Autowired
    ThirdPartyUserService thirdPartyUserService;

    @PostMapping("/newThirdParty/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createThirdParty(@RequestBody ThirdPartyUser thirdPartyUser) {

        thirdPartyUserService.createThirdPartyUser(thirdPartyUser);
}
