package com.gordont.restservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ss")
    LocalDateTime currentTime;
}
