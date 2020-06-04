package com.training.turkcell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CldConfigServerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CldConfigServerApplication.class,
                              args);
    }

}
