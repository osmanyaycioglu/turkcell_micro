package com.training.turkcell.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person/v1")
public class PersonRest {

    @PutMapping
    public String add(final Person person) {
        return "OK";
    }

    @DeleteMapping
    public String delete(final Person person) {
        return "OK";
    }

    @PatchMapping
    public String update(final Person person) {
        return "OK";
    }

    @GetMapping
    public String get(final Long id) {
        return "OK";
    }

}
