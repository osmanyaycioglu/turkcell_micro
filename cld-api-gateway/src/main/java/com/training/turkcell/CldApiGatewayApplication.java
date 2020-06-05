package com.training.turkcell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class CldApiGatewayApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CldApiGatewayApplication.class,
                              args);
    }

}
