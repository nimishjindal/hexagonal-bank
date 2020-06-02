package com.nimish.hexagonalbanking.domain;

import com.nimish.hexagonalbanking.domain.entity.Account;

import java.util.List;
import java.util.Optional;

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

    public Long addBalance(AddBalanceCommand command){
        Account account = accountRepository.findById(command.getId()).get();
        Double newBalance = account.getBalance() + command.getAmount();
        account.setBalance(newBalance);
        return accountRepository.save(account).getId();
    }

    public Optional<Account> findOneAccount(GetOneAccountQuery query){
        return accountRepository.findById(query.getId());
    }

}
