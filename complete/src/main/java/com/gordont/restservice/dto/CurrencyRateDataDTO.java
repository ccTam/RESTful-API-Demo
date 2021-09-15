package com.gordont.restservice.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

/**
 * DTO for adding data
 */
@Data
public class CurrencyRateDataDTO {

    long userId;
    String currencyFrom;
    String currencyTo;
    BigDecimal amountSell;
    BigDecimal amountBuy;
    BigDecimal rate;
    @DateTimeFormat(pattern = "dd-MMM-yyyy hh:mm:ss")
    String timePlaced;
    String originatingCountry;
}
