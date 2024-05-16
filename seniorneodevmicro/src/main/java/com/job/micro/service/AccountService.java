package com.job.micro.service;

import com.job.micro.entity.Account;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountById(Long accountId);

    Account updateAccount(Account account);

    void deleteAccount(Long accountId);
    
}
