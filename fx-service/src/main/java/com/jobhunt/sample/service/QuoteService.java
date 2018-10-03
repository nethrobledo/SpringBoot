package com.jobhunt.sample.service;

import com.jobhunt.sample.dto.QuoteRequestFilter;
import com.jobhunt.sample.dto.QuoteResponseFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

@Service
public class QuoteService implements QuoteServiceImpl {

    private Logger LOGGER = LoggerFactory.getLogger(QuoteService.class);

    @Value("${provider.base.url}")
    private String baseUrl;

    @Value("${provider.payments.quotes}")
    private String paymentQuoteUrl;

    @Autowired
    private OAuth2RestOperations oAuth2RestOperations;

    @Override
    public String postQuote(String currency, BigDecimal amount) {
        LOGGER.info("token is " + oAuth2RestOperations.getAccessToken());
        LOGGER.info("expires at " + oAuth2RestOperations.getAccessToken().getExpiresIn());

        QuoteRequestFilter quoteRequestFilter = new QuoteRequestFilter();
        quoteRequestFilter.setBuyCurrency("USD");
        quoteRequestFilter.setBuyAmount(amount);
        quoteRequestFilter.setSellAmount(new BigDecimal(0));
        quoteRequestFilter.setSellCurrency(currency);

        String url = baseUrl + paymentQuoteUrl;
        HttpEntity request = new HttpEntity(quoteRequestFilter, createHeaders());

        ResponseEntity<LinkedHashMap> response = oAuth2RestOperations.exchange(url, HttpMethod.POST, request, LinkedHashMap.class);
        LOGGER.info("status code is " + response.getStatusCode());

        return (String) response.getBody().get("id");
    }

    @Override
    public QuoteResponseFilter getQuote(String quoteId) {

        LOGGER.info("quote id " + quoteId);
        LOGGER.info("token is " + oAuth2RestOperations.getAccessToken());
        LOGGER.info("expires at " + oAuth2RestOperations.getAccessToken().getExpiresIn());

        String url = baseUrl + paymentQuoteUrl + "/" + quoteId;

        HttpEntity request = new HttpEntity(String.class, createHeaders());

        ResponseEntity<QuoteResponseFilter> response = oAuth2RestOperations.exchange(url, HttpMethod.GET,
                request, QuoteResponseFilter.class);

        return response.getBody();
    }

    /**
     *
     * @return
     */
    private LinkedMultiValueMap<String,Object> createHeaders() {

        LinkedMultiValueMap<String,Object> headers =  new LinkedMultiValueMap<>();
        headers.add(javax.ws.rs.core.HttpHeaders.CONTENT_TYPE, javax.ws.rs.core.MediaType.APPLICATION_JSON);
        headers.add(javax.ws.rs.core.HttpHeaders.ACCEPT, javax.ws.rs.core.MediaType.APPLICATION_JSON);
        headers.add(javax.ws.rs.core.HttpHeaders.AUTHORIZATION, "Bearer " + oAuth2RestOperations.getAccessToken());

        return headers;
    }
}
