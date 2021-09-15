package com.gordont.restservice.service;

import com.gordont.restservice.dto.CurrencyRateDataDTO;

import java.util.ArrayList;

public interface DataStorageService {

    ArrayList<CurrencyRateDataDTO> getCurrencyHistory();

    ArrayList<CurrencyRateDataDTO> addRecord(CurrencyRateDataDTO dto);
}
