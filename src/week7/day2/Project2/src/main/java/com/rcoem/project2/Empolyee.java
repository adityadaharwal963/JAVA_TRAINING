package com.rcoem.project2;

public class Empolyee{
    int id;
    String name;
    Double salary;
    String designation;
    String gender;
    int yearOfJoining;

    public Empolyee(){
    }
    public Empolyee(String name, Double salary, String designation, String gender, int yearOfJoining){
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.gender = gender;
        this.yearOfJoining = yearOfJoining;
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

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
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
