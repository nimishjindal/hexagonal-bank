package com.nimish.hexagonalbanking.domain;

import com.nimish.hexagonalbanking.domain.entity.Account;

public interface AccountRepository {
    Account save(Account account);
    Account findOne(Long id);
}
