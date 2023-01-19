package com.demo.application.service;

import com.demo.application.port.out.AccountLock;
import com.demo.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NoOpAccountLock implements AccountLock {

    @Override
    public void lockAccount(Account.AccountId accountId) {
        log.info("execute NoOpAccountLock.lockAccount()...");
    }

    @Override
    public void releaseAccount(Account.AccountId accountId) {
        log.info("execute NoOpAccountLock.releaseAccount()...");
    }
}
