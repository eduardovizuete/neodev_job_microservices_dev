package com.job.micro.accounttx.service.impl;

import com.job.micro.accounttx.dto.ClientAccTxReportDto;
import com.job.micro.accounttx.entity.Account;
import com.job.micro.accounttx.entity.Client;
import com.job.micro.accounttx.entity.Transaction;
import com.job.micro.accounttx.repository.AccountRepository;
import com.job.micro.accounttx.repository.ClientRepository;
import com.job.micro.accounttx.repository.TransactionRepository;
import com.job.micro.accounttx.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;
import java.util.*;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private WebClient webClient;
    private TransactionRepository transactionRepository;

    @Override
    public List<ClientAccTxReportDto> txByClientAndDate(Long clientId, Instant startDate, Instant endDate) {
        List<ClientAccTxReportDto> transactions = new ArrayList<>();

        Optional<Client> clientByClientId = Optional.ofNullable(webClient.get()
                .uri("http://micropc:8080/api/clients/" + clientId)
                .retrieve()
                .bodyToMono(Client.class)
                .block());
        Client client = clientByClientId.get();

        Set<Account> accounts = client.getAccounts();
        List<Transaction> txsByAccountIdByRangeDates;

        for (Account account : accounts) {
            txsByAccountIdByRangeDates = transactionRepository.findAllByAccountIdAndDateBetween(account.getId(), startDate, endDate);

            for (Transaction tx : txsByAccountIdByRangeDates) {
                ClientAccTxReportDto reportDto = new ClientAccTxReportDto();
                reportDto.setDate(tx.getDate());
                reportDto.setName(client.getName());
                reportDto.setNumberAcc(account.getNumber());
                reportDto.setTypeAcc(account.getType());
                reportDto.setBalanceBeforeTx(tx.getBalanceBeforeTx());
                reportDto.setStatus(account.getStatus());
                reportDto.setAmount(tx.getAmount());
                reportDto.setTypeTx(tx.getType());
                reportDto.setBalanceTx(tx.getBalance());
                transactions.add(reportDto);
            }
        }

        return transactions;
    }

}
