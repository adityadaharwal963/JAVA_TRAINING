import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    /*
     Sort Students Using Comparable
        Problem Statement:
        You are given a list of students with id, name, and marks.
        Sort students based on:
        1. Marks (descending)
        2. Name (alphabetical)
        3. ID (ascending)
        Hint:
        Implement Comparable<Student>.
     */

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ram", 95,101));
        students.add(new Student("Sam", 88,102));
        students.add(new Student("Gama", 95,103));
        students.add(new Student("Kama", 90,104));
        students.add(new Student("Thama", 88,105));


        System.out.println("Students before sorting");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort the list using the compareTo method implemented in the Student class
        Collections.sort(students);

        System.out.println("Students after sorting");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int marks;
    int id;

    Student(String name, int marks,int id) {
        this.name = name;
        this.marks = marks;
        this.id = id;
    }

    @Override
    public int compareTo(Student other) {
        // 1. Sort by Marks (descending)
        int marksComparison = Double.compare(other.marks, this.marks);
        if (marksComparison != 0) {
            return marksComparison;
        }

        // 2. Sort by Name (alphabetical - ascending)
        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }

        // 3. Sort by ID (ascending)
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return name + ": " + marks +" : "+id;
    }
}