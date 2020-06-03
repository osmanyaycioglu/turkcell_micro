package com.training.turkcell;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    private String name = "Osman";

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

}
