/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author ESTUDIANTE
 */
public class Employee implements Comparable<Employee> {
    int code;
    String name;
    float salary;
    String position;

    public Employee(int code, String name, float salary, String position) {
        this.code = code;
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nEmployee{" + "code=" + code + ", name=" + name + ", salary=" + salary + ", position=" + position + "}";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int compareTo(Employee o) {
        return this.code - o.getCode();
    }
    
}
