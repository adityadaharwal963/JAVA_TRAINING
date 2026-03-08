package com.rcoem.project2;

public class Empolyee{
    private Integer id;
    private String name;
    private Double salary;
    private String designation;
    private String gender;
    private Integer yearOfJoining;

    public Empolyee(){
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(Integer yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "______________________________________"+"\n id=" + id +
                "\n name=" + name +
                "\n salary=" + salary +
                "\n designation=" + designation + "\n gender="+ gender +"\n yearOfJoining=" + yearOfJoining;
    }
}
