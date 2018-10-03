package com.jobhunt.sample;

import com.jobhunt.sample.dto.QuoteResponseFilter;
import com.jobhunt.sample.service.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class OfxQuoteController {

    private Logger LOGGER = LoggerFactory.getLogger(OfxQuoteController.class);

    @Autowired
    private QuoteService quoteService;

    @GetMapping(path="/ofx/quote/{currency}/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QuoteResponseFilter getOfx(@PathVariable String currency,
                               @PathVariable BigDecimal amount) {

        String quoteId = quoteService.postQuote(currency, amount);
        QuoteResponseFilter quoteResponseFilter = quoteService.getQuote(quoteId);

        LOGGER.info("buy amount " + quoteResponseFilter.getBuyAmount());
        LOGGER.info("sell amount " + quoteResponseFilter.getSellAmount());
        LOGGER.info("inverse rate " + quoteResponseFilter.getInverseCustomerRate());

        return quoteResponseFilter;
    }

}
