package com.training.turkcell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org")
public class OrganizationRest {

    @Value("${server.port}")
    public int            port;

    @Autowired
    private IEmployeeRest er;

    @GetMapping("/employee/create/{name}")
    public String createEmployee(@PathVariable("name") final String name) {
        return this.er.greetEmployee(name);
    }


}
