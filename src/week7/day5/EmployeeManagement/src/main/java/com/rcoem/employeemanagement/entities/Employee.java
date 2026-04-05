package com.rcoem.employeemanagement.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> juniors;

    @ManyToOne
    @JoinColumn(name = "senior_id")
    private Employee senior;

    public List<Employee> getJuniors() {
        return juniors;
    }

    public void setJuniors(List<Employee> juniors) {
        this.juniors = juniors;
    }

    public Employee getSenior() {
        return senior;
    }

    public void setSenior(Employee senior) {
        this.senior = senior;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
