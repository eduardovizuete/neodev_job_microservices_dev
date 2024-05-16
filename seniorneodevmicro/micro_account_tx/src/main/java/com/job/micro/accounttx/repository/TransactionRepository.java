package com.job.micro.accounttx.repository;

import com.job.micro.accounttx.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
