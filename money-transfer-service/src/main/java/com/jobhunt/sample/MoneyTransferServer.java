package com.jobhunt.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class MoneyTransferServer {

    private Logger logger = LoggerFactory.getLogger(MoneyTransferServer.class);

    public static void main(String args[]) {
        SpringApplication.run(MoneyTransferServer.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        logger.info("Creating rest template..");

        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(interceptors);
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        return restTemplate;
    }
}
