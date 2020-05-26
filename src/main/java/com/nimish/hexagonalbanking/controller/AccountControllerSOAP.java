package com.nimish.hexagonalbanking.controller;

import com.nimish.hexagonalbanking.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

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
