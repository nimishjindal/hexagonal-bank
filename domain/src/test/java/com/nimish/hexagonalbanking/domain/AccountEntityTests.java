package com.nimish.hexagonalbanking.domain;

import com.nimish.hexagonalbanking.domain.entity.Account;
import com.nimish.hexagonalbanking.domain.entity.Txn;
import com.nimish.hexagonalbanking.domain.utils.TxnType;
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

    @Test
    public void Add_Transaction_to_Txn_db_Test(){
        Account account = new Account("nimish",new Date());

        Txn txn = new Txn(account, 500L, TxnType.DEPOSIT);

        assertThat(txn.getAccountId()).isEqualToComparingFieldByField(account);
        assertThat(txn.getAmount()).isEqualTo(500);
        assertThat(txn.getTxnType()).isEqualTo(TxnType.DEPOSIT);

    }

}
