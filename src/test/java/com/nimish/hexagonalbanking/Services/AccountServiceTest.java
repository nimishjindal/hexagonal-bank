package com.nimish.hexagonalbanking.Services;

import com.nimish.hexagonalbanking.entity.Account;
import com.nimish.hexagonalbanking.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

}
