package com.job.micro.accounttx.service;

import com.job.micro.accounttx.dto.ClientAccTxReportDto;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public interface ReportService {

    List<ClientAccTxReportDto> txByClientAndDate(Long clientId, Instant startDate, Instant endDate);

}
