package com.job.micro.accounttx.dto;

import com.job.micro.accounttx.entity.enumeration.TypeTx;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientAccTxReportDto {

    private Instant date;
    private String name;
    private String numberAcc;
    private String typeAcc;
    private Double balanceBeforeTx;
    private TypeTx typeTx;
    private Double amount;
    private Double balanceTx;
    private String status;

}
