package com.nimish.hexagonalbanking.infrastructure.controller.restApi;

import com.nimish.hexagonalbanking.domain.AccountService;
import com.nimish.hexagonalbanking.domain.GetOneAccountQuery;
import com.nimish.hexagonalbanking.domain.entity.Account;
import com.nimish.hexagonalbanking.infrastructure.request.AddBalanceRequest;
import com.nimish.hexagonalbanking.infrastructure.request.CreateAccountRequest;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Long PostUser(@RequestBody CreateAccountRequest request){
        Long aLong = accountService.create(request.toCommand());
        return aLong;
    }

    @PostMapping(value = "/deposit", consumes = "application/json", produces = "application/json")
    public Long deposit(@RequestBody AddBalanceRequest request){
        Long aLong = accountService.addBalance(request.toCommand());
        return aLong;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Account getOneAccount(@PathVariable Long id) {
        try {
            GetOneAccountQuery query = new GetOneAccountQuery(id);
            Optional<Account> maybeAccount = accountService.findOneAccount(query);
            return maybeAccount.get();
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
