package com.job.micro.accounttx.service;

import com.job.micro.accounttx.entity.Account;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountById(Long accountId);

    Account updateAccount(Account account);

    void deleteAccount(Long accountId);
    
}
