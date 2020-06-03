package com.training.turkcell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class MyFirstRest {

    @Autowired
    private MyComponent myComponent;

    public MyFirstRest() {
        System.out.println("MyFirstRest yaratıldı");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World " + this.myComponent.getName();
    }

    @PostMapping("/hello")
    public String hello2() {
        return "Hello World Post " + this.myComponent.getName();
    }

    @GetMapping("/name/{abc}")
    public String name(@PathVariable("abc") final String name) {
        this.myComponent.setName(name);
        return "Set name :  " + name;
    }

}

