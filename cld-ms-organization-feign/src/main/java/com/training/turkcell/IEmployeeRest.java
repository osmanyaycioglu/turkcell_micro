package com.training.turkcell;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "employee")
@RequestMapping("/employee")
public interface IEmployeeRest {

    @GetMapping("/greet/{isim}")
    public String greetEmployee(@PathVariable("isim") final String name);

}
