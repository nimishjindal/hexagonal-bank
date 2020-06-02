package com.nimish.hexagonalbanking.domain;

import com.nimish.hexagonalbanking.domain.entity.Account;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class AddBalanceCommandTest {

    @Test
    public void Add_100_balance_Command_Test() {
        AddBalanceCommand command = new AddBalanceCommand(123L, 100d);

        assertThat(command.getId()).isEqualTo(123L);
        assertThat(command.getAmount()).isEqualTo(100d);

    }

}
