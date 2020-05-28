package com.nimish.hexagonalbanking.infrastructure.service;

import com.nimish.hexagonalbanking.infrastructure.entity.Account;
import com.nimish.hexagonalbanking.infrastructure.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account create(Account account){
        System.out.println("hello");
        System.out.println(account);
        if (account.getName() != null)
            if (!account.getName().isEmpty()) {
                return accountRepository.save(account);
            }
        return null;
    }

    @Override
    public Optional<Account> getOne(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> getAll() {
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public void deleteAll() {
        accountRepository.deleteAll();
    }
}
