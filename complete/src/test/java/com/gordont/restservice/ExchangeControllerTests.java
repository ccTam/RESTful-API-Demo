/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gordont.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.gordont.restservice.dto.CurrencyRateDataDTO;
import com.gordont.restservice.service.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeControllerTests {

    @Autowired
    ExchangeService exchangeService;

    @Test
    public void AddRandomData2List() throws Exception {
        int max = 20;
        for (int i = 0; i < max; i++) {
            CurrencyRateDataDTO dto = new CurrencyRateDataDTO();
            dto.setAmountBuy(getRandomBigDecimal().multiply(new BigDecimal(10000)));
            dto.setAmountSell(getRandomBigDecimal().multiply(new BigDecimal(10000)));
            dto.setCurrencyFrom("EUR");
            dto.setCurrencyTo("GBP");
            dto.setRate(getRandomBigDecimal());
            dto.setOriginatingCountry("FR");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMMM-yy HH:mm:ss");
            dto.setTimePlaced(LocalDateTime.now().format(dtf));
            dto.setUserId(getRandomLong());
            exchangeService.addTrades(dto);
        }
        System.out.println(exchangeService.getExchangeHistory().toString());
        Assert.assertTrue(exchangeService.getExchangeHistory().size() == max);
    }

    private BigDecimal getRandomBigDecimal() {
        Random r = new Random();
        BigDecimal result;
        do {
            result = BigDecimal.valueOf(r.nextDouble());
        } while (BigDecimal.ZERO.compareTo(result) != -1);
        return result;
    }

    private long getRandomLong() {
        Random r = new Random();
        long result;
        do {
            result = r.nextLong();
        } while (result <= 0);
        return result;
    }

}
