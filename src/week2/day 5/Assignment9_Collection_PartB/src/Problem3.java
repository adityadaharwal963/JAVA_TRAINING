import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problem3 {
    /*
    Employee Attendance Tracker
    Scenario:
    An organization tracks daily attendance of employees.
    Requirements:
     Store employee ID and attendance status (Present/Absent)
     Update attendance for an employ
     */

    // store as <empId , attendance>
    static HashMap<Integer,String> attendance = new HashMap<>();


    static void addAttendance(int id,String status){
        attendance.put(id,status);
    }

    static void updateAttendance(int id,String status){
        attendance.put(id,status);
    }

    static  void displayAttendance(){
        System.out.println("Employee Attendance");
        for(Map.Entry<Integer,String> attend: attendance.entrySet()){
            System.out.println(attend.getKey()+" "+attend.getValue());
        }
    }

    public static void main(String[] args) {

        //add employee attendance
        addAttendance(100,"Present");
        addAttendance(101,"Present");
        addAttendance(102,"Absent");
        addAttendance(103,"Present");
        addAttendance(101,"Absent");
        displayAttendance();
        // update employee attendance
        updateAttendance(101,"Present");
        updateAttendance(102,"Present");
        System.out.println("Attendance after updating:");
        displayAttendance();

    }
}
