package com.nimish.hexagonalbanking.domain;

import com.nimish.hexagonalbanking.domain.entity.Account;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Date;
import java.util.Optional;

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

	@Test
	public void Add_100_Amount_to_Account(){
		//Given
		final Account account1 = new Account("Nimish",new Date());
		account1.setBalance(10d);
		account1.setId(1L);

		Optional<Account> opt = Optional.of(account1);

		val updatedAccount = new Account("Nimish",new Date());
		updatedAccount.setId(account1.getId());
		updatedAccount.setBalance(account1.getBalance()+100d);

		ArgumentCaptor<Account> argumentCaptor = forClass(Account.class);
		doReturn(updatedAccount).when(accountRepository).save(argumentCaptor.capture());
		doReturn(opt).when(accountRepository).findById(account1.getId());

		val command = new AddBalanceCommand(1L, 100d);

		//When
		Long balanceUpdated = accountService.addBalance(command);

		//Then
		assertThat(balanceUpdated).isEqualTo(1L);

		val accountArg = argumentCaptor.getValue();
		assertThat(accountArg.getName()).isEqualToIgnoringCase("nimish");
		assertThat(accountArg.getBalance()).isEqualTo(updatedAccount.getBalance());

		Account updatedAccountFetch = accountRepository.findById(1L).get();
		assertThat(updatedAccountFetch.getBalance()).isEqualTo(updatedAccount.getBalance());
	}

	@Test
	public void Get_Account_By_Id_Test(){
		//Given
		final Account account1 = new Account("Nimish",new Date());
		account1.setBalance(10d);
		account1.setId(1L);

		Optional<Account> opt = Optional.of(account1);

		doReturn(opt).when(accountRepository).findById(account1.getId());

		val query = new GetOneAccountQuery(1L);

		//When
		Account accountFound = accountService.findOneAccount(query).get();

		//Then
		assertThat(accountFound.getId()).isEqualTo(account1.getId());
	}

}
