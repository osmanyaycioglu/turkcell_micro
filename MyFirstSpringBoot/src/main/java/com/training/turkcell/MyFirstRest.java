package com.training.turkcell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return "Hello World " + this.myComponent;
    }

    @PostMapping("/hello")
    public String hello2() {
        return "Hello World Post " + this.myComponent;
    }

    @GetMapping("/name/{abc}")
    public String name(@PathVariable("abc") final String name) {
        this.myComponent.setName(name);
        return "Set name :  " + name;
    }

    @GetMapping("/setall/name/{abc}/surname/{xyz}/age/{asd}")
    public String setAll(@PathVariable("abc") final String name,
                         @PathVariable("xyz") final String surname,
                         @PathVariable("asd") final int age) {
        this.myComponent.setName(name);
        this.myComponent.setSurname(surname);
        this.myComponent.setAge(age);
        return "Set all :  " + this.myComponent;
    }

    @GetMapping("/setall2")
    public String setAll2(@RequestParam("abc") final String name,
                          @RequestParam("xyz") final String surname,
                          @RequestParam("asd") final int age) {
        this.myComponent.setName(name);
        this.myComponent.setSurname(surname);
        this.myComponent.setAge(age);
        return "Set all :  " + this.myComponent;
    }

    @GetMapping("/setall3/{isim}")
    public String setAll3(@PathVariable("isim") final String name,
                          @RequestParam("xyz") final String surname,
                          @RequestParam("asd") final int age) {
        this.myComponent.setName(name);
        this.myComponent.setSurname(surname);
        this.myComponent.setAge(age);
        return "Set all :  " + this.myComponent;
    }

    @GetMapping("/setall4")
    public String setAll4(@RequestHeader("isim") final String name,
                          @RequestHeader("xyz") final String surname,
                          @RequestHeader("asd") final int age) {
        this.myComponent.setName(name);
        this.myComponent.setSurname(surname);
        this.myComponent.setAge(age);
        return "Set all :  " + this.myComponent;
    }


}

