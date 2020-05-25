package com.nimish.hexagonalbanking.service;

import com.nimish.hexagonalbanking.entity.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    public Account create(Account account);
    public Optional<Account> getOne(Long id);
    public List<Account> getAll();

}
