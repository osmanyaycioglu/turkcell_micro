package com.training.turkcell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CldDiscoveryServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CldDiscoveryServerApplication.class,
                              args);
    }

}
