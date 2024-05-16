package com.job.micro.accounttx.repository;

import com.job.micro.accounttx.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
