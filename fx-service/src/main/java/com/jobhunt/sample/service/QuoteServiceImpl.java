package com.jobhunt.sample.service;

import com.jobhunt.sample.dto.QuoteResponseFilter;
import java.math.BigDecimal;

public interface QuoteServiceImpl {

    String postQuote(String currency,BigDecimal amount);
    QuoteResponseFilter getQuote(String quoteId);
}
