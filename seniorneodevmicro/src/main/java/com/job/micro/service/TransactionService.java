package com.job.micro.service;

import com.job.micro.entity.Transaction;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction);

    Transaction getTransactionById(Long transactionId);

    Transaction updateTransaction(Transaction transaction);

    void deleteTransaction(Long transactionId);

}
