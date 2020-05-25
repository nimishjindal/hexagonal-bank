package com.nimish.hexagonalbanking.controller.restApi;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.nimish.hexagonalbanking.entity.Account;
import com.nimish.hexagonalbanking.model.User;
import com.nimish.hexagonalbanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/users")
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

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.getAll();
        return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        Optional<Account> maybeAccount = accountService.getOne(id);

        try{
            return new ResponseEntity<Account>(maybeAccount.get(),HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    @PostMapping(path = "/accounts", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Account> PostUser(@RequestBody Account account){
        Account createdAccount = accountService.create(account);
        System.out.println(account);
        System.out.println(createdAccount);

        if(createdAccount!=null) {
            return new ResponseEntity<Account>(createdAccount, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
