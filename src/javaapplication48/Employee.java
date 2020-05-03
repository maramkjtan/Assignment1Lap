/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication48;

/**
 *
 * @author Maram Tanani
 */
public class Employee {
    Integer id;
    String name;
    Double salary;
    String field;

    public Employee() {
    }
    

    public Employee(Integer id, String name, Double salary, String field) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.field = field;
    }

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

    public String getField() {
        return field;
    }

    public void setFeild(String feild) {
        this.field = feild;
    }
    @Override
    public String toString(){
       return String.format("%-5s%-10s%-5s%-5s",id,name,salary,field);
    }
}
