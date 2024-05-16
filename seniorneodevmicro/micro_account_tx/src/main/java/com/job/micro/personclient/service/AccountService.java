package com.job.micro.personclient.service;

import com.job.micro.personclient.entity.Account;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountById(Long accountId);

    Account updateAccount(Account account);

    void deleteAccount(Long accountId);
    
}
