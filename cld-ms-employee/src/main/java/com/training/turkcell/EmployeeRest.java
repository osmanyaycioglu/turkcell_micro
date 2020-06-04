package com.training.turkcell;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRest {

    @Value("${server.port}")
    public int port;

    @GetMapping("/greet/{isim}")
    public String greetEmployee(@PathVariable("isim") final String name) {
        return "Hello " + name + " Port : " + this.port;
    }

}
