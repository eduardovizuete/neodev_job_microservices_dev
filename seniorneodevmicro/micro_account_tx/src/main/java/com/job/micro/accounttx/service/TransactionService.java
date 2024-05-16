package com.job.micro.accounttx.service;

import com.job.micro.accounttx.entity.Transaction;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction);

    Transaction getTransactionById(Long transactionId);

    Transaction updateTransaction(Transaction transaction);

    void deleteTransaction(Long transactionId);

}
