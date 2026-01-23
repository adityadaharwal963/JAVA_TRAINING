package PartA;

import java.util.*;
import java.util.function.Predicate;


class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | ₹" + salary;
    }
}

public class Solution {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Amit", "IT", 60000),
                new Employee(2, "Neha", "HR", 45000),
                new Employee(3, "Raj", "Finance", 75000),
                new Employee(4, "Priya", "IT", 50000),
                new Employee(5, "Karan", "Sales", 82000)
        );

        // Predicate using lambda
        Predicate<Employee> salaryGreaterThan50k =
                e -> e.salary > 50000;

        // Filtering and displaying employees
        employees.stream()
                .filter(salaryGreaterThan50k)
                .forEach(System.out::println);
    }
}
