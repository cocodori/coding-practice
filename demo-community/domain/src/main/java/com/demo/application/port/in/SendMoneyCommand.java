package com.demo.application.port.in;

import com.demo.common.SelfValidating;
import com.demo.domain.Account;
import com.demo.domain.Money;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@EqualsAndHashCode(callSuper = false)
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    @NotNull
    private final Account.AccountId sourceAccountId;

    @NotNull
    private final Account.AccountId targetAccountId;

    @NotNull
    private final Money money;

    public SendMoneyCommand(
            Account.AccountId sourceAccountId,
            Account.AccountId targetAccountId,
            Money money
    ) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        this.validateSelf();
    }

}
