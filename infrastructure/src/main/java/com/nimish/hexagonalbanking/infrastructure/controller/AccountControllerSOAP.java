package com.nimish.hexagonalbanking.infrastructure.controller;

import com.nimish.hexagonalbanking.infrastructure.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountControllerSOAP {

    @GetMapping("accountForm")
    public String accountForm(@ModelAttribute ("registration")Registration registerationModel){
        return "createAccount";
    }

    @PostMapping("accountForm")
    public String postAccount(@ModelAttribute ("registration")Registration registerationModel){
        System.out.println(registerationModel.getName());
        return "createAccount";
    }
}
