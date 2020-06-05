package com.training.turkcell;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/employee")
@RefreshScope
public class EmployeeRest {

    @Value("${server.port}")
    public int    port;

    @Value("${my.name.prop}")
    public String testStr;

    private int   counter = 0;

    @HystrixCommand(fallbackMethod = "fallbackEmployee",
                    commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                                                         value = "500"))
    @GetMapping("/greet/{isim}")
    public String greetEmployee(@PathVariable("isim") final String name) {
        this.counter++;
        if ((this.counter % 3) == 0) {
            try {
                Thread.sleep(1_000);
            } catch (Exception eLoc) {
            }
        }
        if ((this.counter % 5) == 0) {
            throw new IllegalStateException();
        }
        return "Hello " + name + " Port : " + this.port;
    }

    public String fallbackEmployee(final String name) {
        return "Hello new employee " + name;
    }


    @GetMapping("/test")
    public String test() {
        return "Value : " + this.testStr;
    }

}
