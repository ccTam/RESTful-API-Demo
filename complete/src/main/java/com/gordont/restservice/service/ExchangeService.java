package com.gordont.restservice.service;

import com.gordont.restservice.dto.CurrencyRateDataDTO;

import java.util.ArrayList;

public interface ExchangeService {
    CurrencyRateDataDTO addTrades(CurrencyRateDataDTO dto);

    ArrayList<CurrencyRateDataDTO> getExchangeHistory();
}
