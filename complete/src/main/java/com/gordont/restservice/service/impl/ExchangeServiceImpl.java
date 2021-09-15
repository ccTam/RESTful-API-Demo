package com.gordont.restservice.service.impl;

import com.gordont.restservice.dto.CurrencyRateDataDTO;
import com.gordont.restservice.service.DataStorageService;
import com.gordont.restservice.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    DataStorageService dataStorageService;

    /**
     * Add a new trade record
     *
     * @param dto CurrencyRateDataDTO
     * @return CurrencyRateDataDTO
     */
    public CurrencyRateDataDTO addTrades(CurrencyRateDataDTO dto) {
        dataStorageService.addRecord(dto);
        return dto;
    }

    /**
     * Get the list of added data
     *
     * @return ArrayList of CurrencyRateDataDTO
     */
    @Override
    public ArrayList<CurrencyRateDataDTO> getExchangeHistory() {
        return dataStorageService.getCurrencyHistory();
    }

}
