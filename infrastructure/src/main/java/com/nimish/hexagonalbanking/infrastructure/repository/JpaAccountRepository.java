package com.nimish.hexagonalbanking.infrastructure.repository;

import com.nimish.hexagonalbanking.domain.AccountRepository;
import com.nimish.hexagonalbanking.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaAccountRepository extends AccountRepository,JpaRepository<Account,Long> {
}
