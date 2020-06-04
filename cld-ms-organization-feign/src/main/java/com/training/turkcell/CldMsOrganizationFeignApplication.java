package com.training.turkcell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CldMsOrganizationFeignApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CldMsOrganizationFeignApplication.class,
                              args);
    }

}
