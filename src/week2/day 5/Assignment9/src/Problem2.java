import java.util.HashMap;

public class Problem2 {
    /*
    Student Marks Lookup
    Concept: HashMap
    Problem
    Store student names and marks.
    Then search marks of a given student.
    Input
    4
    Amit 78
    Neha 85
    Ravi 72
    Pooja 90
    Search: Neha
    Output
    85
     */

    final private  static HashMap<String,Integer> marksheet = new HashMap<>();
    static void searchMarks(String StudentName){
        if(marksheet.containsKey(StudentName)){
            System.out.println("Student Marks: " + marksheet.get(StudentName));
        }else {
            System.out.println("Student Nit Found");
        }
    }

    public static void main(String[] args) {
        // Add student marks to marksheet
        marksheet.put("Amit", 78);
        marksheet.put("Neha",85);
        marksheet.put("Ravi", 72);
        marksheet.put("Pooja", 90);

        // search student marks
        searchMarks("Neha");
    }
}
