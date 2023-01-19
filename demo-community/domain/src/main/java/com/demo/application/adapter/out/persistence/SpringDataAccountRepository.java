package com.demo.application.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAccountRepository extends JpaRepository<AccountJpaEntity, Long> {
}
