package com.jobhunt.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MoneyTransferController {

    @GetMapping("/money-transfer/quote/{currency}/{amount}")
    public QuoteConversionBean getQuote(@PathVariable String currency,
                                        @PathVariable BigDecimal amount) {
        QuoteConversionBean quoteConversionBean = new QuoteConversionBean();
        quoteConversionBean.setRate("0.715");
        quoteConversionBean.setBuyCurrency("AUD");

        return quoteConversionBean;

    }
}
