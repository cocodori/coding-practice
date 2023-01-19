package com.demo.application.port.out;

import com.demo.domain.Account;

public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}
