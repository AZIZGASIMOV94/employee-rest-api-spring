package com.company.dto;

import com.company.entity.Employee;

public class EmployeeDTO {

    private int id;
    private String name;
    private String surname;
    private Double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String name, String surname, Double salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public EmployeeDTO(Employee employee){
        this.id = employee.getId();
        this.name = employee.getName();
        this.surname = employee.getSurname();
        this.salary = employee.getSalary();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
