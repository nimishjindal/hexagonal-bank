package com.nimish.hexagonalbanking.infrastructure.controller.restApi;

import com.nimish.hexagonalbanking.infrastructure.request.CreateAccountRequest;
import com.nimish.hexagonalbanking.domain.AccountService;
import com.nimish.hexagonalbanking.infrastructure.response.CreateAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /*
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


 */

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Long PostUser(@RequestBody CreateAccountRequest request){
        Long aLong = accountService.create(request.toCommand());
        return aLong;
    }

}
