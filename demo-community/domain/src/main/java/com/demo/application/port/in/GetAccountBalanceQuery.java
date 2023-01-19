package com.demo.application.port.in;

import com.demo.domain.Account;
import com.demo.domain.Money;

@FunctionalInterface
public interface GetAccountBalanceQuery {
    Money getAccountBalance(Account.AccountId accountId);
}
