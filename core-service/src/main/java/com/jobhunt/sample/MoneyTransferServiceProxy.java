package com.jobhunt.sample;

import com.jobhunt.sample.bean.QuoteConversionBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@EnableAutoConfiguration
@FeignClient(name="money-transfer-service")
public interface MoneyTransferServiceProxy {

    @GetMapping("/money-transfer/quote/{currency}/{amount}")
    QuoteConversionBean getQuote(@PathVariable("currency") String currency,
                                 @PathVariable("amount") BigDecimal amount);

}
