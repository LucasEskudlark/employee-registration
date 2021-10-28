package entities;

public class Employee {
    // Employee id
    private Integer id;
    // Employee name
    private String name;
    // Employee salary
    private Double salary;

    // Constructor
    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // Methods
    /* The increaseSalary method receives a percentage and increases
    * the employee(object) salary based on the percentage value*/
    public double increaseSalary(double percentage) {
        percentage = percentage / 100;
        return this.salary += this.salary * percentage;
    }

    // toString() Override
    public String toString() {
        return id + ", " + name + ", " + salary;
    }

}
