package com.nimish.hexagonalbanking.Services;

import com.nimish.hexagonalbanking.entity.Account;
import com.nimish.hexagonalbanking.service.AccountService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AccountServiceTest {

	@Autowired
	AccountService accountService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateAccountNimish() {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = simpleDateFormat.parse("1997-01-23");

			final Account account1 = new Account("Nimish", dob);
			final Account account2 = new Account("not Nimish", dob);

			Account createdAccount = accountService.create(account1);

			assertThat(createdAccount)
					.isNotNull()
					.isEqualToComparingFieldByField(account1);
			assertThat(createdAccount.getId())
					.isNotEqualTo(account2.getId());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAccountNimish() {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = simpleDateFormat.parse("1997-01-23");

			final Account account1 = new Account("Nimish", dob);
			final Account account2 = new Account("Not Nimish", dob);

			Account createdAccount = accountService.create(account1);
			Account createdAccount2 = accountService.create(account2);

			Optional<Account> gotAccount = accountService.getOne(account1.getId());

			assertThat(gotAccount)
					.isNotEmpty();

			assertThat(gotAccount.get().getId())
					.isEqualTo(account1.getId())
					.isNotEqualTo(account2.getId());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllAccounts(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			accountService.deleteAll();

			Date dob = simpleDateFormat.parse("1997-01-23");

			Account account1 = new Account("Nimish",dob);
			Account account2 = new Account("Nimish2",dob);
			Account account3 = new Account("Nimish 3",dob);
			Account account4 = new Account("4 Nimish",dob);
			Account account5 = new Account("5 Nimish",dob);

			Account createdAccount1 = accountService.create(account1);
			Account createdAccount2 = accountService.create(account2);
			Account createdAccount3 = accountService.create(account3);
			Account createdAccount4 = accountService.create(account4);

			List<Account> accounts = accountService.getAll();

			assertThat(accounts)
					.hasSize(4);
			assertThat(accounts.get(1).getId())
					.isEqualTo(createdAccount2.getId());


		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
