package com.job.micro.personclient.repository;

import com.job.micro.personclient.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
