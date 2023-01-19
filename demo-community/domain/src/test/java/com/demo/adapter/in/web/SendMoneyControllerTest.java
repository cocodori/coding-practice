package com.demo.adapter.in.web;

import com.demo.application.adapter.in.web.SendMoneyController;
import com.demo.application.port.in.SendMoneyCommand;
import com.demo.application.port.in.SendMoneyUseCase;
import com.demo.domain.Account;
import com.demo.domain.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SendMoneyController.class)
public class SendMoneyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SendMoneyUseCase sendMoneyUseCase;

    @Test
    void testSendMoney() throws Exception {
        mockMvc.perform(
                post("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}",
                        41, 42, 500
                ).header("Content-Type", "application/json"))
                .andExpect(status().isOk())
                .andDo(print());

        then(sendMoneyUseCase).should()
                .sendMoney(eq(new SendMoneyCommand(
                        new Account.AccountId(41L),
                        new Account.AccountId(42L),
                        Money.of(500L))));
    }
}
