package com.gordont.restservice.service.impl;

import com.gordont.restservice.dto.CurrencyRateDataDTO;
import com.gordont.restservice.service.DataStorageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataStorageServiceImpl implements DataStorageService {

    static ArrayList<CurrencyRateDataDTO> currencyHistory;

    /**
     * Get a full list of added records
     *
     * @return ArrayList of CurrencyRateDataDTO
     */
    public ArrayList<CurrencyRateDataDTO> getCurrencyHistory() {
        InitHistoryList();
        return currencyHistory;
    }

    /**
     * Add a new trade record
     *
     * @param dto CurrencyRateDataDTO
     * @return ArrayList of CurrencyRateDataDTO
     */
    public ArrayList<CurrencyRateDataDTO> addRecord(CurrencyRateDataDTO dto) {
        InitHistoryList();
        currencyHistory.add(dto);
        return currencyHistory;
    }

    /**
     * Init the list if it is the first time
     */
    private void InitHistoryList() {
        if (currencyHistory == null) {
            currencyHistory = new ArrayList<>();
        }
    }
}
