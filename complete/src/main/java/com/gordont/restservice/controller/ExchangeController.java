package com.gordont.restservice.controller;

import com.gordont.restservice.dto.CurrencyRateDataDTO;
import com.gordont.restservice.dto.CurrencyHistoryRecordsDTO;
import com.gordont.restservice.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Endpoint for exchange data related services
 */

@RestController
@RequestMapping("/api")
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @PostMapping("/addexchangedata")
    public CurrencyRateDataDTO ExchangeFeed(@RequestBody CurrencyRateDataDTO dto) {
        System.out.println(dto.toString());
        return exchangeService.addTrades(dto);
    }

    /**
     * Current implementation will only use memory as a DB for POC purpose. In production environment, actual DB is necessary to avoid buffer overflow or memory leak
     * @return CurrencyHistoryRecordsDTO
     */
    @GetMapping("/getexchangehistory")
    public CurrencyHistoryRecordsDTO GetCurrencyHistory() {
        ArrayList<CurrencyRateDataDTO> list = exchangeService.getExchangeHistory();
        CurrencyHistoryRecordsDTO results = new CurrencyHistoryRecordsDTO();
        results.setHistoryRecords(list);
        results.setResultSize(list.size());
        results.setCurrentTime(LocalDateTime.now());
        System.out.println(results);
        return results;
    }
}
