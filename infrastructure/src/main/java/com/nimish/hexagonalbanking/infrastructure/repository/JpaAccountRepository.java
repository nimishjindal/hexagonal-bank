package com.nimish.hexagonalbanking.infrastructure.repository;

import com.nimish.hexagonalbanking.domain.AccountRepository;
import com.nimish.hexagonalbanking.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends AccountRepository,JpaRepository<Account,Long> {
}
