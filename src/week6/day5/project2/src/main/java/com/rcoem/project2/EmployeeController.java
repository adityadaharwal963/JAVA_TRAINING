package com.rcoem.project2;

import java.util.ArrayList;

public class EmployeeController {
    final private static ArrayList<Employee> employees = new ArrayList<>();
    static int count = 100;

    public int addEmployee(String name, double salary,int age) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setAge(age);
        count++;
        employee.setId(count);
        employees.add(employee);
        return employees.size();
    }

    public void getEmployee(int index) {
        Employee employee = employees.get(index);
        System.out.println("________________________________");
        System.out.println("Name: "+employee.getName());
        System.out.println("Salary: "+employee.getSalary());
        System.out.println("Age: "+employee.getAge());
        System.out.println("Id: "+employee.getId());
        System.out.println("________________________________");
    }

    public void filterById(int id) {
        employees.stream().filter(employee -> employee.getId() == id).findFirst().ifPresent(employee->{
            System.out.println("________________________________");
            System.out.println("Name: "+employee.getName());
            System.out.println("Salary: "+employee.getSalary());
            System.out.println("Age: "+employee.getAge());
            System.out.println("Id: "+employee.getId());
            System.out.println("________________________________");
        });

    }

    public void filterByName(String name,boolean ascending) {
        employees.stream().filter(employee -> {
            return employee.getName().equals(name);
        }).sorted((e1,e2)->{
            if (ascending) {
                return e1.getSalary() >= e2.getSalary()?1:-1;
            }
            return e1.getSalary() < e2.getSalary()?-1:1;
        }).forEach(employee -> {
            System.out.println("________________________________");
            System.out.println("Name: "+employee.getName());
            System.out.println("Salary: "+employee.getSalary());
            System.out.println("Age: "+employee.getAge());
            System.out.println("Id: "+employee.getId());
            System.out.println("________________________________");
        });
    }
    public void filterBySalary(double salary,boolean ascending) {
        employees.stream().filter(employee -> {
            return employee.getSalary() == salary;
        }).sorted((e1,e2)->{
            if (ascending) {
                return e1.getSalary() >= e2.getSalary()?1:-1;
            }
            return e1.getSalary() < e2.getSalary()?-1:1;
        }).forEach(employee -> {
            System.out.println("________________________________");
            System.out.println("Name: "+employee.getName());
            System.out.println("Salary: "+employee.getSalary());
            System.out.println("Age: "+employee.getAge());
            System.out.println("________________________________");
        });
    }


}
