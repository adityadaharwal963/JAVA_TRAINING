import java.util.*;

public class Problem10 {
    /*
    Course Registration System
    Scenario:
    Students register for multiple courses.
    Requirements:
     Store course name and registered students
     Avoid duplicate student registration per course
     Display students per course
    Hint:
    Use Map<String, Set<String>>
     */


    static HashMap<String, Set<String>> courseData = new HashMap<>();

    static void displayCourseReport(){
        //Display students per course
        System.out.println("Course registration Report");
        for(Map.Entry<String,Set<String>> data :courseData.entrySet()){
            System.out.println("Course Name: "+ data.getKey());
            for(String student: data.getValue()){
                System.out.print(student+" ");
            }
            System.out.println();
        }
    }

    static void registerStudents(String course, String[] students){

        if(courseData.containsKey(course)){
            courseData.get(course).addAll(Arrays.asList(students));
        }else {
            courseData.put(course,new HashSet<>(Arrays.asList(students)));
        }
    }

    public static void main(String[] args) {
        // get some student list  wants to register in courses
        String[] studentList1 ={"A","B","D","E","A","B"};
        String[] studentList2 ={"A","C","A"};
        String[] studentList3 ={"A","B","C","D","E"};
        // register student in course
        registerStudents("Math",studentList1);
        registerStudents("Science",studentList2);
        registerStudents("English",studentList3);

        //Display students per course
        displayCourseReport();
    }
}