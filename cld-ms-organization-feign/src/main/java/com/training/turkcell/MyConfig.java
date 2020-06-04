package com.training.turkcell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyConfig {

    @Autowired
    private IEmployeeRest rest;

    @Scheduled(fixedDelay = 5000)
    public void xyz() {
        System.out.println(this.rest.greetEmployee("osman"));
    }

}
