package com.nimsh.hexagonalbanking.domain;

import com.nimsh.hexagonalbanking.domain.entity.Account;

public interface AccountRepository {
    Account save(Account account);
    Account findOne(Long id);
}
