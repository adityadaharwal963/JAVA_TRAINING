import java.util.HashMap;
import java.util.Map;

public class Problem6 {
    /*
    College Admission System
    Concept: Set
    Scenario
    During admissions, duplicate application IDs must be avoided.
    Task
    1. Read application IDs.
    2. Store them in a Set.
    3. Display only valid unique applications.
     */

    // Hashmap to store application id and application as  value
    final static HashMap<String,StudentApplication> applications = new HashMap<>();

    static void displayAdmissions(){
        for(Map.Entry<String,StudentApplication> application:applications.entrySet()){
            System.out.println(application.getValue());
        }
    }

    public static void main(String[] args) {
        // generate student application
        StudentApplication s1 = new StudentApplication("100","Ram");
        StudentApplication s2 = new StudentApplication("100","Raa");
        StudentApplication s3 = new StudentApplication("102","Rag");
        StudentApplication s4 = new StudentApplication("101","Rom");

        // add student application to application system
        applications.put(s1.getId(),s1);
        applications.put(s2.getId(),s2);
        applications.put(s3.getId(),s3);
        applications.put(s4.getId(),s4);

        // display unique student Admissions application
        displayAdmissions();
    }

}

class StudentApplication{
    private String id;
    private String name;

    public StudentApplication(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student Application: " +
                "id='" + id + '\'' +
                ", name='" + name + '\'';
    }
}