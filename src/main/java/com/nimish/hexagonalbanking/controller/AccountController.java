package com.nimish.hexagonalbanking.controller;

import com.nimish.hexagonalbanking.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AccountController {

    @GetMapping("accountForm")
    public String accountForm(@ModelAttribute ("registration")Registration registerationModel){
        return "createAccount";
    }
}
