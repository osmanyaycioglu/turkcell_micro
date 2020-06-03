package com.training.turkcell;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement
public class MyComponent {

    private String name = "Osman";
    @NotEmpty(message = "Surname boş olamaz")
    @Size(min = 2, max = 100, message = "Surname min 2 max 100 olabilir")
    private String surname;
    @Min(value = 10, message = "Age 10 dan küçük olamaz")
    @Max(value = 150, message = "Age 150 den büyük olamaz")
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
