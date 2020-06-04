package com.training.turkcell;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrganizationConfig {

    @Bean
    @LoadBalanced
    @Qualifier("loadbalanced")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Qualifier("direct")
    public RestTemplate restTemplate2() {
        return new RestTemplate();
    }


}
