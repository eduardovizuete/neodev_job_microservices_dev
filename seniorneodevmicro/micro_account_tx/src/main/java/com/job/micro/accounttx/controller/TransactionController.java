package com.job.micro.accounttx.controller;

import com.job.micro.accounttx.service.TransactionService;
import com.job.micro.accounttx.entity.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/transactions")
@Transactional
public class TransactionController {
    
    private TransactionService txService;

    // build create transaction REST API
    // http://localhost:8080/api/transaction/
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        Transaction savedTransaction = txService.createTransaction(transaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    // build get transaction by id REST API
    // http://localhost:8080/api/transactions/1
    @GetMapping("{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") Long transactionId){
        Transaction transaction = txService.getTransactionById(transactionId);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    // build update transaction REST API
    // http://localhost:8080/api/transactions/1
    @PutMapping("{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") Long transactionId,
                                                 @RequestBody Transaction transaction){
        transaction.setId(transactionId);
        Transaction updatedTransaction = txService.updateTransaction(transaction);
        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
    }

    // build delete transaction REST API
    // http://localhost:8080/api/transactions/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long transactionId){
        txService.deleteTransaction(transactionId);
        return new ResponseEntity<>("Transaction successfully deleted!", HttpStatus.OK);
    }
    
}
