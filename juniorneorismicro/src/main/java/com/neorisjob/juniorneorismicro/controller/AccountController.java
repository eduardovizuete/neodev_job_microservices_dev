package com.neorisjob.juniorneorismicro.controller;

import com.neorisjob.juniorneorismicro.entity.Account;
import com.neorisjob.juniorneorismicro.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
@Transactional
public class AccountController {

    private AccountService accountService;

    // build create account REST API
    // http://localhost:8080/api/account/
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account savedAccount = accountService.createAccount(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    // build get account by id REST API
    // http://localhost:8080/api/accounts/1
    @GetMapping("{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long accountId){
        Account account = accountService.getAccountById(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // build update account REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/accounts/1
    public ResponseEntity<Account> updateAccount(@PathVariable("id") Long accountId,
                                               @RequestBody Account account){
        account.setId(accountId);
        Account updatedAccount = accountService.updateAccount(account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    // build delete account REST API
    @DeleteMapping("{id}")
    // http://localhost:8080/api/accounts/1
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long accountId){
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>("Account successfully deleted!", HttpStatus.OK);
    }

}
