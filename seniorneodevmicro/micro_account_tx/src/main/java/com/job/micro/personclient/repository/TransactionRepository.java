package com.job.micro.personclient.repository;

import com.job.micro.personclient.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
