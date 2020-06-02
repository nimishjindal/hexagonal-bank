package com.nimish.hexagonalbanking.infrastructure;

import com.nimish.hexagonalbanking.domain.AccountService;
import com.nimish.hexagonalbanking.domain.AddBalanceCommand;
import com.nimish.hexagonalbanking.domain.CreateAccountCommand;
import com.nimish.hexagonalbanking.infrastructure.controller.restApi.AccountController;
import com.nimish.hexagonalbanking.infrastructure.request.AddBalanceRequest;
import com.nimish.hexagonalbanking.infrastructure.request.CreateAccountRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AccountControllerTest {

	private AccountService accountService = mock(AccountService.class);
	private AccountController accountController = new AccountController(accountService);

    @Test
    public void should_convert_request_to_command_and_call_service(){

        //given
        CreateAccountRequest request = mock(CreateAccountRequest.class);
        CreateAccountCommand command = mock(CreateAccountCommand.class);
        doReturn(command).when(request).toCommand();
        doReturn(1234L).when(accountService).create(command);

        //when
        Long accountId = accountController.PostUser(request);

        //then
        assertThat(accountId).isEqualTo(1234L);
        verify(accountService,times(1)).create(command);

    }

    @Test
    public void should_convert_request_to_add_balance_Command_and_call_service(){

        //given
        AddBalanceRequest request = mock(AddBalanceRequest.class);
        AddBalanceCommand command = mock(AddBalanceCommand.class);
        doReturn(command).when(request).toCommand();
        doReturn(1234L).when(accountService).addBalance(command);

        //when
        Long accountId = accountController.deposit(request);

        //then
        assertThat(accountId).isEqualTo(1234L);
        verify(accountService,times(1)).addBalance(command);

    }

}