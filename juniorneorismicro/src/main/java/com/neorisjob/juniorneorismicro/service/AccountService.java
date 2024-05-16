package com.neorisjob.juniorneorismicro.service;

import com.neorisjob.juniorneorismicro.entity.Account;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountById(Long accountId);

    Account updateAccount(Account account);

    void deleteAccount(Long accountId);
    
}
