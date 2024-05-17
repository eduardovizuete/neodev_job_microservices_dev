package com.job.micro.accounttx.service.impl;

import com.job.micro.accounttx.entity.Account;
import com.job.micro.accounttx.entity.Transaction;
import com.job.micro.accounttx.exception.UnavailableBalanceException;
import com.job.micro.accounttx.repository.AccountRepository;
import com.job.micro.accounttx.repository.TransactionRepository;
import com.job.micro.accounttx.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        Optional<Account> accountExist = accountRepository.findById(transaction.getAccount().getId());
        Account account = accountExist.get();
        transaction.setAccount(account);
        transaction.setBalanceBeforeTx(account.getBalance());

        switch (transaction.getType()) {
            case DEPOSIT:
                transaction.setBalance(account.getBalance() + transaction.getAmount());
                break;
            case WITHDRAWAL:
                if (transaction.getAmount() > account.getBalance()) {
                    throw new UnavailableBalanceException("Balance unavailable");
                }

                transaction.setBalance(account.getBalance() - transaction.getAmount());
                break;
        }

        account.setBalance(transaction.getBalance());
        accountRepository.save(account);

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        return transaction.get();
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        Transaction existingTx = transactionRepository.findById(transaction.getId()).get();
        existingTx.setDate(transaction.getDate());
        existingTx.setType(transaction.getType());
        existingTx.setAmount(transaction.getAmount());
        existingTx.setBalance(transaction.getBalance());

        return transactionRepository.save(existingTx);
    }

    @Override
    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(Long accountId) {
        List<Transaction> transactions = transactionRepository.findAllByAccountId(accountId);
        return transactions;
    }

    @Override
    public List<Transaction> getTransactionByAccountIdAndDateBetween(Long accountId, Instant dateStart, Instant dateEnd) {
        List<Transaction> transactions = transactionRepository.findAllByAccountIdAndDateBetween(accountId, dateStart, dateEnd);
        return transactions;
    }

}
