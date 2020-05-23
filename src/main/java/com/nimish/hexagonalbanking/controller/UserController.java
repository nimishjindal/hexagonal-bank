package com.nimish.hexagonalbanking.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.nimish.hexagonalbanking.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(
            @RequestParam(value="firstname", defaultValue = "NimishDefault") String firstname,
            @RequestParam(value="lastname", defaultValue = "JindalDefault") String lastname,
            @RequestParam(value="age", defaultValue = "22") int age)
    {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user")
    public User PostUser(User user){
        System.out.println(user);
        return user;
    }
}
