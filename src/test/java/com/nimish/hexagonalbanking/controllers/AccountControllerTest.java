package com.nimish.hexagonalbanking.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimish.hexagonalbanking.controller.restApi.AccountController;
import com.nimish.hexagonalbanking.entity.Account;
import com.nimish.hexagonalbanking.repository.AccountRepository;
import com.nimish.hexagonalbanking.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	AccountService accountService;

	@MockBean
	AccountRepository accountRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateAccountNimish(){
		try {
			/*
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = simpleDateFormat.parse("1997-01-23");

			Account account = new Account("Nimish",dob);
			*/

			String body = "{" +
					"\"name\":\"nimish\","+
					"\"dob\":\"1997-01-23\""+
					"}";

			mockMvc.perform(
					MockMvcRequestBuilders.post("/accounts")
							.content(body)
							.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
			)
					.andExpect(status().isCreated());
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

			mockMvc.perform(
					MockMvcRequestBuilders.post("/accounts")
							.content(asJsonString(account))
							.contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON)
			)
					.andExpect(status().is4xxClientError());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
