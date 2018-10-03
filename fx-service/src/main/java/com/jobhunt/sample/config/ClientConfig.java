package com.jobhunt.sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.Arrays;

@EnableOAuth2Client
@Configuration
public class ClientConfig {

    @Value("${provider.base.url}")
    private String baseUrl;

    @Value("${provider.token.url}")
    private String tokenUrl;

    @Value("${provider.clientId}")
    private String clientId;

    @Value("${provider.clientSecret}")
    private String clientSecret;

    @Value("${provider.payments")
    private String quoteUrl;

    @Bean
    ClientCredentialsResourceDetails clientCredentialsResourceDetails() {
        final ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setClientId(clientId);
        resourceDetails.setClientSecret(clientSecret);
        resourceDetails.setAccessTokenUri(baseUrl + tokenUrl);
        resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.form);
        resourceDetails.setScope(Arrays.asList("payments"));
        return resourceDetails;
    }

    @Bean
    public OAuth2RestOperations restTemplate() {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails(), new DefaultOAuth2ClientContext
                (new DefaultAccessTokenRequest()));
    }
}
