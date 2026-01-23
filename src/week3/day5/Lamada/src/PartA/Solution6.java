package PartA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
    int rollNo;
    String name;
    double marks;

    Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    public String toString() {
        return rollNo + " " + name + " " + marks;
    }
}


public class Solution6 {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(1, "Amit", 78),
                new Student(2, "Neha", 35),
                new Student(3, "Ravi", 64),
                new Student(4, "Priya", 90)
        );

        // Passed students
        System.out.println("Passed Students:");
        students.stream()
                .filter(s -> s.marks >= 40)
                .forEach(System.out::println);

        // Average marks
        double average = students.stream()
                .mapToDouble(Student::getMarks)
                .average()
                .orElse(0);
        System.out.println("Average Marks: " + average);

        // Topper
        Student topper = students.stream()
                .max(Comparator.comparingDouble(s -> s.marks))
                .orElse(null);

        System.out.println("Topper: " + topper);
    }
}
