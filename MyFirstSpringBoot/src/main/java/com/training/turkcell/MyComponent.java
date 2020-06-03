package com.training.turkcell;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    private String name = "Osman";
    private String surname;
    private int    age;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }


    public String getSurname() {
        return this.surname;
    }


    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }


    public int getAge() {
        return this.age;
    }


    public void setAge(final int ageParam) {
        this.age = ageParam;
    }

    @Override
    public String toString() {
        return "MyComponent [name=" + this.name + ", surname=" + this.surname + ", age=" + this.age + "]";
    }


}
