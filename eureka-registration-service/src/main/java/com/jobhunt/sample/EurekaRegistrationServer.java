package com.jobhunt.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistrationServer {
    public static void main(String args[]) {
        SpringApplication.run(EurekaRegistrationServer.class, args);
    }
}
