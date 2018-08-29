package com.jobhunt.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class MoneyTransferController {

    @Autowired MoneyTransferServiceProxy moneyTransferServiceProxy;

    @GetMapping("/money-transfer/quote/{currency}/{amount}")
    public QuoteConversionBean getQuote(@PathVariable String currency, @PathVariable BigDecimal amount) {
        return moneyTransferServiceProxy.getQuote(currency, amount);
    }


}
