package com.training.turkcell;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableRabbit
@EnableHystrix
public class CldMsOrganizationFeignApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CldMsOrganizationFeignApplication.class,
                              args);
    }

}
