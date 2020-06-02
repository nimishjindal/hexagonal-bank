package com.nimish.hexagonalbanking.bootstrap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimish.hexagonalbanking.domain.AccountService;
import com.nimish.hexagonalbanking.domain.AddBalanceCommand;
import com.nimish.hexagonalbanking.domain.entity.Account;
import com.nimish.hexagonalbanking.infrastructure.repository.JpaAccountRepository;
import com.nimish.hexagonalbanking.infrastructure.request.AddBalanceRequest;
import com.nimish.hexagonalbanking.infrastructure.request.CreateAccountRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class DepositApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private JpaAccountRepository accountRepository;

    @Test
    void contextLoads() {
    }

	@Test
	public void test_deposit_100_to_Nimish_account(){
		try {

            Date dob = new Date();
            Account account = new Account("Nimish",dob);
            account.setBalance(10d);
            account.setId(123L);
            doReturn(account).when(accountRepository).save(account);

            AddBalanceRequest request = new AddBalanceRequest(account.getId(), 100d);
            byte[] payload = this.mapper.writeValueAsBytes(request);

            RequestBuilder requestObj = post("/accounts/deposit")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payload);

            String createdId = mockMvc.perform(requestObj)
                    .andExpect(status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            Long Id = Long.valueOf(createdId);

            Account created = accountRepository.findById(Id).get();
            assertThat(created.getId()).isEqualTo(Id);
            assertThat(created.getBalance()).isEqualTo(110d);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}