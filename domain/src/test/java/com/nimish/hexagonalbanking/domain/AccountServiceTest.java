package com.nimish.hexagonalbanking.domain;

import com.nimish.hexagonalbanking.domain.AccountRepository;
import com.nimish.hexagonalbanking.domain.AccountService;
import com.nimish.hexagonalbanking.domain.CreateAccountCommand;
import com.nimish.hexagonalbanking.domain.entity.Account;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class AccountServiceTest {

	private final AccountRepository accountRepository = mock(AccountRepository.class);
	private final AccountService accountService = new AccountService((accountRepository));

	@Test
	public void testCreateAccountNimish() {
		final Account account1 = new Account();

		val created = new Account();
		created.setId(1L);

		ArgumentCaptor<Account> argumentCaptor = forClass(Account.class);
		doReturn(created).when(accountRepository).save(argumentCaptor.capture());

		//Given
		Date dob = new Date();
		val command = new CreateAccountCommand("Nimish",dob);

		//When
		Long idCreated = accountService.create(command);

		//Then
		assertThat(idCreated).isEqualTo(1L);

		val accountArg = argumentCaptor.getValue();
		assertThat(accountArg.getId()).isNull();
		assertThat(accountArg.getName()).isEqualToIgnoringCase("nimish");
		assertThat(accountArg.getDob()).isEqualTo(dob);
	}

}
