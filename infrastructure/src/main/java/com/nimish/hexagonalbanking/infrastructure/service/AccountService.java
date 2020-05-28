package com.nimish.hexagonalbanking.infrastructure.service;

import com.nimish.hexagonalbanking.infrastructure.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    public Account create(Account account);
    public Optional<Account> getOne(Long id);
    public List<Account> getAll();
    public void deleteAll();

}
