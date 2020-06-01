package com.nimish.hexagonalbanking.infrastructure.repositories;
/*
import com.nimish.hexagonalbanking.domain.entity.Account;
import com.nimish.hexagonalbanking.infrastructure.repository.AccountRepository;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setUp(){
        accountRepository.deleteAll();
    }

    @Test
    public void testDeleteAccountNimish() {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = simpleDateFormat.parse("1997-01-23");

            final Account account1 = new Account("Nimish", dob);
            final Account account2 = new Account("Not Nimish", dob);

            accountRepository.save(account1);
            accountRepository.save(account2);

            accountRepository.deleteByName("Nimish");

            List<Account> resultSetAfterDeletingNimish = (List<Account>) accountRepository.findAll();

            System.out.println("hello");
            System.out.println(resultSetAfterDeletingNimish.get(0));

            assertThat(resultSetAfterDeletingNimish).hasSize(1);
            assertThat(resultSetAfterDeletingNimish.get(0))
                    .isEqualToComparingFieldByField(account2)
                    .isNotEqualTo(account1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCreateAccountNimish(){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = simpleDateFormat.parse("1997-01-23");

            final Account account1 = new Account("Nimish", dob);
            final Account account2 = new Account("Not Nimish", dob);
            final Account account3 = new Account("Not Saved", dob);

            accountRepository.save(account1);
            accountRepository.save(account2);

            List<Account> nimishAccountResultSet= (List<Account>) accountRepository.findAll();

            assertThat(nimishAccountResultSet)
                    .hasSize(2)
                    .contains(account1,account2)
                    .doesNotContain(account3);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFindAccountNimishById(){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = simpleDateFormat.parse("1997-01-23");

            final Account account1 = new Account("Nimish", dob);
            final Account account2 = new Account("Not Nimish", dob);

            Account savedAccount1 = accountRepository.save(account1);
            accountRepository.save(account2);

            Optional<Account> nimishAccountResultSet= accountRepository.findById(savedAccount1.getId());

            assertThat(nimishAccountResultSet)
                    .isNotEmpty()
                    .contains(account1);

            assertThat(nimishAccountResultSet.get().getId())
                    .isNotEqualTo(account2.getId())
                    .isEqualTo(account1.getId());

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUpdateBalanceAccountNimish(){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = simpleDateFormat.parse("1997-01-23");

            final Account account1 = new Account("Nimish", dob);

            Account account = accountRepository.save(account1);

            Optional<Account> nimishAccount= accountRepository.findById(account.getId());

            Double updatedBalance = nimishAccount.get().getBalance() + 299d;
            nimishAccount.get().setBalance(updatedBalance);

            Account updatedAccount = accountRepository.save(nimishAccount.get());

            assertThat(updatedAccount)
                    .isEqualTo(nimishAccount.get());

            assertThat(updatedAccount.getBalance())
                    .isEqualTo(299d)
                    .isNotEqualTo(0d);


        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}


 */