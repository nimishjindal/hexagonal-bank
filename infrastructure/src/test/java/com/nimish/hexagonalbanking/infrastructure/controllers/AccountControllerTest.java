package com.nimish.hexagonalbanking.infrastructure.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimish.hexagonalbanking.domain.AccountService;
import com.nimish.hexagonalbanking.domain.CreateAccountCommand;
import com.nimish.hexagonalbanking.infrastructure.controller.restApi.AccountController;
import com.nimish.hexagonalbanking.infrastructure.request.CreateAccountRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(AccountController.class)
class AccountControllerTest {

	//@Autowired
	//private MockMvc mockMvc;

	//@Autowired
	//ObjectMapper mapper;

	private AccountService accountService = mock(AccountService.class);
	private AccountController accountController = new AccountController(accountService);

	//@Test
	//void contextLoads() {
	//}

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

	/*
	@Test
	public void testCreateAccountNimish(){
		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = simpleDateFormat.parse("1997-01-23");

            CreateAccountRequest request = new CreateAccountRequest("Nimish",dob);

			when(accountService.create(Mockito.any(CreateAccountCommand.class))).thenReturn(1234L);

			// Build post request with vehicle object payload
			MockHttpServletRequestBuilder builder = buildPostJsonPayload("/accounts",request);

			mockMvc.perform(builder)
                    .andExpect(status().isOk());
                    //.andExpect(status().isCreated())
					//.andExpect(jsonPath("$.name", is(account.getName())));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAccountNimishWithId(){
		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = simpleDateFormat.parse("1997-01-23");

			Account account = new Account("Nimish",dob);
			account.setId(1L);

			when(accountService.getOne(1L)).thenReturn(java.util.Optional.of(account));

			MockHttpServletRequestBuilder builder = buildGetJsonPayload("/accounts/1",null);

			mockMvc.perform(builder)
					.andExpect(status().isOk());

			builder = buildGetJsonPayload("/accounts/2",null);

			mockMvc.perform(builder)
					.andExpect(status().isBadRequest());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllAccounts(){
		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = simpleDateFormat.parse("1997-01-23");

			Account account = new Account("Nimish",dob);
			account.setId(1L);
			Account account2 = new Account("Nimish 2",dob);
			account.setId(2L);

			ArrayList<Account> accounts = new ArrayList<Account>();

			accounts.add(account);
			accounts.add(account2);

			when(accountService.getAll()).thenReturn(accounts);

			MockHttpServletRequestBuilder builder = buildGetJsonPayload("/accounts",null);

			mockMvc.perform(builder)
					.andExpect(status().isOk());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetNoAccounts(){
		try {

			when(accountService.getAll()).thenReturn(null);

			MockHttpServletRequestBuilder builder = buildGetJsonPayload("/accounts",null);

			mockMvc.perform(builder)
					.andExpect(status().isOk());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNotCreateAccountNull(){
		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = simpleDateFormat.parse("1997-01-23");

			Account account = new Account("",dob);
			account.setId(1L);

			when(accountService.create(Mockito.any(Account.class))).thenReturn(null);

			MockHttpServletRequestBuilder builder = buildPostJsonPayload("/accounts", account);

			mockMvc.perform(builder)
					.andExpect(status().isBadRequest());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	MockHttpServletRequestBuilder buildPostJsonPayload(String url, Object obj) throws JsonProcessingException {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(url)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(this.mapper.writeValueAsBytes(obj));
		return builder;
	}

	MockHttpServletRequestBuilder buildGetJsonPayload(String url, Object obj) throws JsonProcessingException {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(obj==null?null:this.mapper.writeValueAsBytes(obj));
		return builder;
	}
 	*/
}