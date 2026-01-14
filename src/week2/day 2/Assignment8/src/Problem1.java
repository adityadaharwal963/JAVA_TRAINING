import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Problem1 {
    /*
    Student Attendance Manager (Set + List)
    Objective
    Store student attendance where:
     Duplicate entries are not allowed
     Order of attendance must be preserved
    Tasks
    1. 2. 3. Accept student roll numbers using a List.
    Convert the list into a LinkedHashSet.
    Display the final attendance list.
    Concepts Used
    List, Set, LinkedHashSet
     */

    static void displayAttendance(ArrayList<String> attendance){
        LinkedHashSet<String> students = new LinkedHashSet<>();
        students.addAll(attendance);
        System.out.println("Student attendance:");
        for(String student : students ){
            System.out.println(student);
        }
        System.out.println("Total Student Present: "+students.size());
    }

    public static void main(String[] args) {
        ArrayList<String> attendance = new ArrayList<>();
        attendance.add("Ram");
        attendance.add("Ramo");
        attendance.add("Rocky");
        attendance.add("Monty");
        attendance.add("Ram");
        displayAttendance(attendance);
    }

}
