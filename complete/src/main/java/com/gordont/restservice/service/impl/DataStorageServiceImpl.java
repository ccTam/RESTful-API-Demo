package com.gordont.restservice.service.impl;

import com.gordont.restservice.dto.CurrencyRateDataDTO;
import com.gordont.restservice.service.DataStorageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataStorageServiceImpl implements DataStorageService {

    static ArrayList<CurrencyRateDataDTO> currencyHistory;

    public ArrayList<CurrencyRateDataDTO> getCurrencyHistory() {
        InitHistoryList();
        return currencyHistory;
    }

    public ArrayList<CurrencyRateDataDTO> addRecord(CurrencyRateDataDTO dto) {
        InitHistoryList();
        currencyHistory.add(dto);
        return currencyHistory;
    }

    private void InitHistoryList() {
        if (currencyHistory == null) {
            currencyHistory = new ArrayList<>();
        }
    }
}
