package com.training.turkcell;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
public class CldMsDepartmentApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CldMsDepartmentApplication.class,
                              args);
    }

}
