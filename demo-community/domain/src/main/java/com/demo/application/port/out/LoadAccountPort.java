package com.demo.application.port.out;

import com.demo.domain.Account;

import java.time.LocalDateTime;

public interface LoadAccountPort {
    Account loadAccount(Account.AccountId accountId, LocalDateTime baselineDate);
}
