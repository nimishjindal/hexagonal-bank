package com.nimish.hexagonalbanking.infrastructure.controller.restApi;

import com.nimish.hexagonalbanking.infrastructure.entity.Account;
import com.nimish.hexagonalbanking.infrastructure.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.getAll();
        return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
    }

    @GetMapping("/{id}")
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

    @PostMapping(consumes = "application/json", produces = "application/json")
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
