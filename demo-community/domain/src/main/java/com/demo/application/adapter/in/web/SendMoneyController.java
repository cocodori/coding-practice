package com.demo.application.adapter.in.web;

import com.demo.application.port.in.SendMoneyCommand;
import com.demo.application.port.in.SendMoneyUseCase;
import com.demo.common.WebAdapter;
import com.demo.domain.Account;
import com.demo.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(
            @PathVariable Long sourceAccountId,
            @PathVariable Long targetAccountId,
            @PathVariable Long amount
    ) {
        SendMoneyCommand command = new SendMoneyCommand(
                new Account.AccountId(sourceAccountId),
                new Account.AccountId(targetAccountId),
                Money.of(amount)
        );

        sendMoneyUseCase.sendMoney(command);
    }

}
