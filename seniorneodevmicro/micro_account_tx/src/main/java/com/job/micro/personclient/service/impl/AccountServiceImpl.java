package com.job.micro.personclient.service.impl;

import com.job.micro.personclient.entity.Account;
import com.job.micro.personclient.entity.Client;
import com.job.micro.personclient.repository.AccountRepository;
import com.job.micro.personclient.repository.ClientRepository;
import com.job.micro.personclient.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private ClientRepository clientRepository;

    @Override
    public Account createAccount(Account account) {
        Optional<Client> client = clientRepository.findByClientId(account.getClient().getClientId());
        account.setClient(client.get());
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        return account.get();
    }

    @Override
    public Account updateAccount(Account account) {
        Account existingAccount = accountRepository.findById(account.getId()).get();
        existingAccount.setNumber(account.getNumber());
        existingAccount.setType(account.getType());
        existingAccount.setBalance(account.getBalance());
        existingAccount.setStatus(account.getStatus());

        return accountRepository.save(existingAccount);
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

}
