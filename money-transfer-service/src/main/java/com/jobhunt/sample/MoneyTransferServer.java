package com.jobhunt.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MoneyTransferServer {
    public static void main(String args[]) {
        SpringApplication.run(MoneyTransferServer.class, args);
    }
}
