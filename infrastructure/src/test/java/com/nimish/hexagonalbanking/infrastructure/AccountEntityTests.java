package com.nimish.hexagonalbanking.infrastructure;

import com.nimish.hexagonalbanking.infrastructure.entity.Account;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class AccountEntityTests {

    @Test
    public void createAccountWithNameNimishTest(){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = simpleDateFormat.parse("1997-01-23");

            Account account = new Account("Nimish",dob);

            assertThat(account.getName()).isEqualToIgnoringCase("nimish");
            assertThat(account.getName()).isNotEqualTo("Not nimish");
            assertThat(account.getDob()).isEqualTo(dob);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
