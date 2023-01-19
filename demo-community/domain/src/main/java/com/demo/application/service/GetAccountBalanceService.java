package com.demo.application.service;

import com.demo.application.port.in.GetAccountBalanceQuery;
import com.demo.application.port.out.LoadAccountPort;
import com.demo.domain.Account;
import com.demo.domain.Money;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(Account.AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now())
                .calculateBalance();
    }

}

