import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem4 {
    /*
    4. Sort Employees by ID
    Concept: TreeMap
    Problem
    Store employee ID and name, and display them in ascending order of ID.
    Input
    103 Ravi
    101 Amit
    105 Neha
    102 Pooja 
    Output
    101 Amit
    102 Pooja
    103 Ravi
    105 Neha
    Requirement
    Use TreeMap<Integer, String>
     */

    final private  static TreeMap<Integer,String> employees = new TreeMap<>();
    static void displayLogs(){
        // TreeMap Maintains sorted order of key 
        for(Map.Entry<Integer,String> log: employees.entrySet()){
            System.out.println(log.getKey()+" "+log.getValue());
        }
    }

    public static void main(String[] args) {
        // Add  employees
        employees.put(103,"Ravi");
        employees.put(101, "Amit");
        employees.put(105,"Neha");
        employees.put(102,"Pooja");
        // display sorted employees by ids
        displayLogs();
    }
}
