package com.nimish.hexagonalbanking.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimish.hexagonalbanking.controller.restApi.AccountController;
import com.nimish.hexagonalbanking.entity.Account;
import com.nimish.hexagonalbanking.service.AccountService;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;


@WebMvcTest(AccountController.class)
class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	AccountService accountService;

	@Autowired
	ObjectMapper mapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateAccountNimish(){
		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dob = simpleDateFormat.parse("1997-01-23");

			Account account = new Account("Nimish",dob);
			account.setId(1L);

			when(accountService.create(Mockito.any(Account.class))).thenReturn(account);

			// Build post request with vehicle object payload
			MockHttpServletRequestBuilder builder = buildPostJsonPayload("/accounts",account);

			mockMvc.perform(builder)
					.andExpect(status().isCreated())
					.andExpect(jsonPath("$.name", is(account.getName())));

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

}
