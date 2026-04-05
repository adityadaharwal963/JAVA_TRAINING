package com.rcoem.employeemanagement.DTO;

import com.rcoem.employeemanagement.entities.Employee;

import java.util.List;
import java.util.Set;

public class EmployeeDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String username;
    private String name;
    private String role;
    private Set<String> permission;
    private Employee senior;
    private List<Employee> juniors;

    public Employee getSenior() {
        return senior;
    }

    public void setSenior(Employee senior) {
        this.senior = senior;
    }

    public List<Employee> getJuniors() {
        return juniors;
    }

    public void setJuniors(List<Employee> juniors) {
        this.juniors = juniors;
    }

    public Set<String> getPermission() {
        return permission;
    }

    public void setPermission(Set<String> permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
