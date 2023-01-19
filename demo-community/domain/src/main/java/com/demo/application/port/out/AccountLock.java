package com.demo.application.port.out;

import com.demo.domain.Account;

public interface AccountLock {
    void lockAccount(Account.AccountId accountId);

    void releaseAccount(Account.AccountId accountId);
}
