package com.job.micro.personclient.service;

import com.job.micro.personclient.entity.Transaction;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction);

    Transaction getTransactionById(Long transactionId);

    Transaction updateTransaction(Transaction transaction);

    void deleteTransaction(Long transactionId);

}
