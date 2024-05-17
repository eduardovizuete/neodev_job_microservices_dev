package com.job.micro.accounttx.service;

import com.job.micro.accounttx.entity.Transaction;

import java.time.Instant;
import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction);

    Transaction getTransactionById(Long transactionId);

    Transaction updateTransaction(Transaction transaction);

    void deleteTransaction(Long transactionId);

    List<Transaction> getTransactionsByAccountId(Long accountId);

    List<Transaction> getTransactionByAccountIdAndDateBetween(Long accountId, Instant dateStart, Instant dateEnd);

}
