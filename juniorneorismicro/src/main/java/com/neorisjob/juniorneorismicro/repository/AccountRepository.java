package com.neorisjob.juniorneorismicro.repository;

import com.neorisjob.juniorneorismicro.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
