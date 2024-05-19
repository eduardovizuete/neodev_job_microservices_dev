package com.job.micro.accounttx.service;

import com.job.micro.accounttx.entity.Account;
import reactor.core.publisher.Mono;

public interface AccountService {

    Account createAccount(Account account);

    Mono<Account> createAccountAsync(Account account);

    Account getAccountById(Long accountId);

    Account updateAccount(Account account);

    void deleteAccount(Long accountId);
    
}
