package com.demo.application.adapter.out.persistence;

import com.demo.application.port.out.LoadAccountPort;
import com.demo.application.port.out.UpdateAccountStatePort;
import com.demo.common.PersistenceAdapter;
import com.demo.domain.Account;
import com.demo.domain.Activity;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {

    private final SpringDataAccountRepository accountRepository;
    private final ActivityRepository activityRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(Account.AccountId accountId, LocalDateTime baselineDate) {

        AccountJpaEntity account = accountRepository.findById(accountId.value())
                .orElseThrow(EntityNotFoundException::new);

        List<ActivityJpaEntity> activities =
                activityRepository.findByOwnerSince(accountId.value(), baselineDate);

        Long withdrawalBalance = orZero(activityRepository
                .getWithdrawalBalanceUntil(accountId.value(), baselineDate));

        Long depositBalance = orZero(activityRepository
                .getDepositBalanceUnit(accountId.value(), baselineDate));

        return accountMapper.mapToDomainEntity(
                account,
                activities,
                withdrawalBalance,
                depositBalance
        );
    }

    private Long orZero(Long value) {
        return value == null ? 0L : value;
    }

    @Override
    public void updateActivities(Account account) {
        for (Activity activity : account.getActivityWindow().getActivities()) {
            if (activity.getId() == null) {
                activityRepository.save(accountMapper.mapToJpaEntity(activity));
            }
        }
    }
}
