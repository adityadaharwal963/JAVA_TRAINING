import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Problem9 {
    /*
    City Temperature Report
    Concept: TreeMap
    Scenario
    A weather system stores city temperatures and must display them in alphabetical order of city
    names.
    Task
    1. Store city → temperature.
    2. Display sorted report.
    3. Show highest and lowest temperature cities.
     */

    final private  static TreeMap<String,Integer> temperatures = new TreeMap<>();
    static void displayReports(){

        System.out.println("Temperature report");
        // TreeMap Maintains sorted order of key
        for(Map.Entry<String,Integer> log: temperatures.entrySet()){
            System.out.println(log.getKey()+" "+log.getValue());
        }
    }

    static void displayHighLowTemperature(){
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        String HighCity="";
        String LowCity="";
        for(Map.Entry<String,Integer> log: temperatures.entrySet()){
            if(log.getValue()>=high){
               high = log.getValue();
               HighCity = log.getKey();
            }
            if(log.getValue()<=low){
                low = log.getValue();
                LowCity = log.getKey();
            }
        }
        System.out.println("Highest Temp: "+HighCity);
        System.out.println("Lowest Temp: "+LowCity);
    }

    public static void main(String[] args) {
        // Add cities temperatures
        temperatures.put("Mumbai",35);
        temperatures.put("Delhi",45);
        temperatures.put("Nagpur",40);
        temperatures.put("Pune",36);
        // display sorted temperatures report
        displayReports();
        displayHighLowTemperature();
    }
}
