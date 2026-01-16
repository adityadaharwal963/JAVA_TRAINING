import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem3 {
    /*
    3. Maintain Insertion Order of Login Logs
    Concept: LinkedHashMap
    Problem
    Store user login records in the order they occurred.
    Display the logs exactly in the same order.
    Input
    Raj 09:00
    Amit 09:05
    Neha 09:10
    Output
    Raj 09:00
    Amit 09:05
    Neha 09:10
    Requirement
    Use LinkedHashMap
     */


    final private  static LinkedHashMap<String,String> logs = new LinkedHashMap<>();
    static void displayLogs(){
       // LinkHashMap Maintains order of insertion
        for(Map.Entry<String,String> log: logs.entrySet()){
            System.out.println(log.getKey()+" "+log.getValue());
        }
    }

    public static void main(String[] args) {
        // Add login logs
        logs.put("Raj","09:00");
        logs.put("Amit", "09:05");
        logs.put("Neha","09:10");
        // display Ordered Logs
        displayLogs();
    }
}
