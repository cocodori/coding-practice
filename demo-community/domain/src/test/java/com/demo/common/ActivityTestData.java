package com.demo.common;

import com.demo.domain.Account;
import com.demo.domain.Activity;
import com.demo.domain.Money;

import java.time.LocalDateTime;

public class ActivityTestData {

    public static ActivityBuilder defaultActivity() {
        return new ActivityBuilder()
                .withOwnerAccount(new Account.AccountId(42L))
                .withSourceAccount(new Account.AccountId(42L))
                .withTargetAccount(new Account.AccountId(41L))
                .withTimestamp(LocalDateTime.now())
                .withMoney(Money.of(999L));
    }

    public static class ActivityBuilder {
        private Activity.ActivityId id;
        private Account.AccountId ownerAccountId;
        private Account.AccountId sourceAccountId;
        private Account.AccountId targetAccountId;
        private LocalDateTime timestamp;
        private Money money;

        public ActivityBuilder withId(Activity.ActivityId activityId) {
            this.id = activityId;
            return this;
        }

        public ActivityBuilder withOwnerAccount(Account.AccountId accountId) {
            this.ownerAccountId = accountId;
            return this;
        }

        public ActivityBuilder withSourceAccount(Account.AccountId accountId) {
            this.sourceAccountId = accountId;
            return this;
        }

        public ActivityBuilder withTargetAccount(Account.AccountId accountId) {
            this.targetAccountId = accountId;
            return this;
        }

        public ActivityBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ActivityBuilder withMoney(Money money) {
            this.money = money;
            return this;
        }

        public Activity build() {
            return new Activity(
                    this.id,
                    this.ownerAccountId,
                    this.sourceAccountId,
                    this.targetAccountId,
                    this.timestamp,
                    this.money
            );
        }
    }
}
