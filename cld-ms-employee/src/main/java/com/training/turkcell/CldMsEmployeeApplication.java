package com.training.turkcell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CldMsEmployeeApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CldMsEmployeeApplication.class,
                              args);
    }

}
