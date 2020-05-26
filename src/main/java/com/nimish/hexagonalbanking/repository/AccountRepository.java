package com.nimish.hexagonalbanking.repository;

import com.nimish.hexagonalbanking.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
    void deleteByName(String name);
}
