package com.nimsh.hexagonalbanking.domain;

import com.nimsh.hexagonalbanking.domain.entity.Account;

public class AccountService{

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long create(CreateAccountCommand command){
        Account account = new Account(
                command.getName(), command.getDob()
        );
        return accountRepository.save(account).getId();
    }

}
