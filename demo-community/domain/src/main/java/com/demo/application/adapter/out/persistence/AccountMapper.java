package com.demo.application.adapter.out.persistence;

import com.demo.domain.Account;
import com.demo.domain.Activity;
import com.demo.domain.ActivityWindow;
import com.demo.domain.Money;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {

    Account mapToDomainEntity(
            AccountJpaEntity account,
            List<ActivityJpaEntity> activities,
            Long withdrawalBalance,
            Long depositBalance
    ) {
        Money baselineBalance = Money.substract(
                Money.of(depositBalance),
                Money.of(withdrawalBalance));

        return Account.withId(
                new Account.AccountId(account.getId()),
                baselineBalance,
                mapToActivityWindow(activities));

    }

    private ActivityWindow mapToActivityWindow(List<ActivityJpaEntity> activities) {
        List<Activity> mappedActivities = new ArrayList<>();

        for (ActivityJpaEntity activity : activities) {
            mappedActivities.add(new Activity(
                    new Activity.ActivityId(activity.getId()),
                    new Account.AccountId(activity.getOwnerAccountId()),
                    new Account.AccountId(activity.getSourceAccountId()),
                    new Account.AccountId(activity.getTargetAccountId()),
                    activity.getTimestamp(),
                    Money.of(activity.getAmount())));
        }

        return new ActivityWindow(mappedActivities);
    }

    ActivityJpaEntity mapToJpaEntity(Activity activity) {
        return new ActivityJpaEntity(
                activity.getId() == null ? null : activity.getId().value(),
                activity.getTimestamp(),
                activity.getOwnerAccountId().value(),
                activity.getSourceAccountId().value(),
                activity.getTargetAccountId().value(),
                activity.getMoney().amount().longValue());
    }
}
