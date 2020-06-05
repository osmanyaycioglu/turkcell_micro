package com.training.turkcell;

public class Department {

    private long   id;
    private String name;
    private String email;
    private int    employeeCount;

    public long getId() {
        return this.id;
    }

    public void setId(final long idParam) {
        this.id = idParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    public int getEmployeeCount() {
        return this.employeeCount;
    }

    public void setEmployeeCount(final int employeeCountParam) {
        this.employeeCount = employeeCountParam;
    }

    @Override
    public String toString() {
        return "Department [id="
               + this.id
               + ", name="
               + this.name
               + ", email="
               + this.email
               + ", employeeCount="
               + this.employeeCount
               + "]";
    }


}
