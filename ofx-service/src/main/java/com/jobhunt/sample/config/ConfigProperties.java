package com.jobhunt.sample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configprops.properties")
@ConfigurationProperties(prefix = "provider")
public class ConfigProperties {

}
