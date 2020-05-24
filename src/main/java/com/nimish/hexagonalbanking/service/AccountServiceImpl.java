package com.nimish.hexagonalbanking.service;

import com.nimish.hexagonalbanking.entity.Account;
import com.nimish.hexagonalbanking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> getOne(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> getAll() {
        return null;
    }
}
