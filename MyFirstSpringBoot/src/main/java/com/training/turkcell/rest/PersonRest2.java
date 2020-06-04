package com.training.turkcell.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person/v1")
public class PersonRest2 {

    @PostMapping("/add")
    public String add(final Person person) {
        return "OK";
    }

    @PostMapping("/delete")
    public String delete(final Person person) {
        return "OK";
    }

    @PostMapping("/update")
    public String update(final Person person) {
        return "OK";
    }

    @GetMapping("/get")
    public String get(final Long id) {
        return "OK";
    }

    @GetMapping("/get-all")
    public String getAll(final Long id) {
        return "OK";
    }

}
