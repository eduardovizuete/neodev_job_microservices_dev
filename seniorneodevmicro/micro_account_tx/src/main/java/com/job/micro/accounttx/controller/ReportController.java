package com.job.micro.accounttx.controller;

import com.job.micro.accounttx.dto.ClientAccTxReportDto;
import com.job.micro.accounttx.service.ReportService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reports")
@Transactional
public class ReportController {

    private ReportService reportService;

    // Build REST API get report of account statement transactions by client and range of dates
    // http://localhost:8081/api/reports?
    //                                  clientId=1&
    //                                  startDate=2024-05-16T09:41:00Z&
    //                                  endDate=2024-05-17T09:42:00Z
    @GetMapping
    public ResponseEntity<List<ClientAccTxReportDto>> getAccountStatement(@RequestParam Long clientId,
                                                                          @RequestParam Instant startDate,
                                                                          @RequestParam Instant endDate) {
        List<ClientAccTxReportDto> report = reportService.txByClientAndDate(clientId, startDate, endDate);
        return new ResponseEntity<>(report, HttpStatus.OK);
    }

}
