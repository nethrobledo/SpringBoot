package com.jobhunt.sample;

import com.jobhunt.sample.bean.TokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

@RestController
public class MoneyTransferController {

    private Logger LOGGER = LoggerFactory.getLogger(MoneyTransferController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ofxaaa/quote/{currency}/{amount}")
    public QuoteConversionBean getOfx(@PathVariable String currency,
                                        @PathVariable BigDecimal amount) {

        /*String url = baseUrl + tokenUrl;
        LOGGER.info("OFX url is " + url);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("grant_type","client_credentials");
        params.add("scope","payments");

        HttpEntity<LinkedMultiValueMap<String, Object>> request = new HttpEntity<>(params, headers);
        TokenResponse tokenResponse = restTemplate.postForObject(url, request, TokenResponse.class);
        LOGGER.info("token " + tokenResponse.getAccess_token());
        LOGGER.info("expire " + tokenResponse.getExpires_in());*/

        QuoteConversionBean quoteConversionBean = new QuoteConversionBean();
        quoteConversionBean.setRate("0.715");
        quoteConversionBean.setBuyCurrency("AUD");

        return quoteConversionBean;

    }

    @GetMapping("/westernunion/quote/{currency}/{amount}")
    public QuoteConversionBean getWesternUnion(@PathVariable String currency,
                                      @PathVariable BigDecimal amount) {

        /*String url = baseUrl + tokenUrl;
        LOGGER.info("Western union is " + url);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("grant_type","client_credentials");
        params.add("scope","payments");

        HttpEntity<LinkedMultiValueMap<String, Object>> request = new HttpEntity<>(params, headers);
        TokenResponse tokenResponse = restTemplate.postForObject(url, request, TokenResponse.class);
        LOGGER.info("token " + tokenResponse.getAccess_token());
        LOGGER.info("expire " + tokenResponse.getExpires_in());*/

        QuoteConversionBean quoteConversionBean = new QuoteConversionBean();
        quoteConversionBean.setRate("0.715");
        quoteConversionBean.setBuyCurrency("AUD");

        return quoteConversionBean;

    }
}
