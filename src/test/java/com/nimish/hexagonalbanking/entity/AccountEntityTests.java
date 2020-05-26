package com.nimish.hexagonalbanking.entity;

import com.nimish.hexagonalbanking.repository.FlightRepository;
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
