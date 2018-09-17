package com.jobhunt.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class OfxQuoteController {

    private Logger LOGGER = LoggerFactory.getLogger(OfxQuoteController.class);

    @Autowired
    private OAuth2RestOperations restTemplate;

    @GetMapping("/ofx/quote/{currency}/{amount}")
    public QuoteConversionBean getOfx(@PathVariable String currency,
                                        @PathVariable BigDecimal amount) {

        System.out.println("test, token is " + restTemplate.getAccessToken());
        System.out.println("value is " + restTemplate.getAccessToken().getValue());
        System.out.println("expires is " + restTemplate.getAccessToken().getExpiresIn());

        QuoteConversionBean quoteConversionBean = new QuoteConversionBean();
        quoteConversionBean.setRate("0.715");
        quoteConversionBean.setBuyCurrency("AUD");

        return quoteConversionBean;

    }

}
