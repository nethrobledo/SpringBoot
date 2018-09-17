package com.jobhunt.sample;

import com.jobhunt.sample.bean.QuoteConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class MoneyTransferController {

    @Autowired
    OfxServiceProxy ofxServiceProxy;

    @GetMapping("/ofx/quote/{currency}/{amount}")
    public QuoteConversionBean getOfx(@PathVariable String currency, @PathVariable BigDecimal amount) {
        return ofxServiceProxy.getOfx(currency, amount);
    }

    //@GetMapping("/westernunion/quote/{currency}/{amount}")
    //public QuoteConversionBean getWesternUnion(@PathVariable String currency, @PathVariable BigDecimal amount) {
    //    return moneyTransferServiceProxy.getWesternUnion(currency, amount);
    //}

}
