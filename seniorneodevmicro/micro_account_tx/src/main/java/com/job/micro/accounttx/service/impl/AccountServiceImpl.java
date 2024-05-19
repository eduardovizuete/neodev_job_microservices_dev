package com.job.micro.accounttx.service.impl;

import com.job.micro.accounttx.entity.Account;
import com.job.micro.accounttx.entity.Client;
import com.job.micro.accounttx.repository.AccountRepository;
import com.job.micro.accounttx.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private WebClient webClient;

    @Override
    public Account createAccount(Account account) {
        Optional<Client> client = Optional.ofNullable(webClient.get()
                .uri("http://micropc:8080/api/clients/" + account.getClient().getClientId())
                .retrieve()
                .bodyToMono(Client.class)
                .block());

        account.setClient(client.get());
        return accountRepository.save(account);
    }

    public Mono<Account> createAccountAsync(Account account) {
        // Perform the asynchronous GET call
        Mono<Client> responseClient = webClient.get()
                .uri("http://micropc:8080/api/clients/"
                        + account.getClient().getClientId())
                .retrieve()
                .bodyToMono(Client.class);

        // Use the response to create a new entity account and return it
        return responseClient.map(respAsyncClient -> {
            account.setClient(respAsyncClient);
            return accountRepository.save(account);
        });
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
