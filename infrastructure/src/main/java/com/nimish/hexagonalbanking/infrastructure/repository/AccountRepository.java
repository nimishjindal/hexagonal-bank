package com.nimish.hexagonalbanking.infrastructure.repository;

import com.nimish.hexagonalbanking.infrastructure.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
    void deleteByName(String name);
}
