package com.neorisjob.juniorneorismicro.service;

import com.neorisjob.juniorneorismicro.entity.Transaction;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction);

    Transaction getTransactionById(Long transactionId);

    Transaction updateTransaction(Transaction transaction);

    void deleteTransaction(Long transactionId);

}
