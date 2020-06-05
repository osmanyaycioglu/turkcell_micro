package com.training.turkcell;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/org")
public class OrganizationRest {

    @Value("${server.port}")
    public int             port;

    @Autowired
    private IEmployeeRest  er;

    @Autowired
    private RabbitTemplate rt;

    @HystrixCommand(fallbackMethod = "fallbackEmployee",
                    commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                                                         value = "500"))
    @GetMapping("/employee/create/{name}")
    public String createEmployee(@PathVariable("name") final String name) {
        return this.er.greetEmployee(name);
    }

    public String fallbackEmployee(final String name) {
        return "Fallback : " + name;
    }


    @GetMapping("/department/test/{dep}")
    public String departmentTest(@PathVariable("dep") final String key) {
        Department departmentLoc = new Department();
        departmentLoc.setId(5);
        departmentLoc.setEmployeeCount(100);
        departmentLoc.setName("IT");
        departmentLoc.setEmail("xyz@zxcc.com");
        this.rt.convertAndSend("dep_exch",
                               key,
                               departmentLoc);

        return "OK";
    }


}
