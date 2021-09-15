package com.gordont.restservice.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * DTO to return full list of data
 */

@Data
public class CurrencyHistoryRecordsDTO {

    ArrayList<CurrencyRateDataDTO> historyRecords;
    int resultSize;
    LocalDateTime currentTime;
}
