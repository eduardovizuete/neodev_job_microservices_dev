package com.neorisjob.juniorneorismicro.repository;

import com.neorisjob.juniorneorismicro.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
