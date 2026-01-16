import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


class Patient implements Comparable<Patient>{
    int priority;
    String name;

    public Patient(int priority, String name) {

        this.priority = priority;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Patient o) {
        return this.priority - o.priority;
    }
}

public class Problem7 {
     /*
    Hospital Patient Priority System
    Scenario:
    Emergency patients are treated based on severity.
    Requirements:
     Store patient name and priority level
     Treat patient with highest priority first
     Display remaining patients
    Hint:
    Use PriorityQueue<Patient> with Comparator
     */


    static PriorityQueue<Patient> waitingList = new PriorityQueue<>();

    static void treatPatient(){
        if(!waitingList.isEmpty()){
            System.out.print("Treating : ");
            System.out.println(waitingList.poll());
        }else {
            System.out.println("No Patient");
        }
    }

    static void printRemainingPatient(){
        System.out.println("Remaining Patient");
        ArrayList<Patient> remaining = new ArrayList<>(waitingList);
        for(Patient p : remaining){
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        // add people to queue
        waitingList.add(new Patient(3,"Raghu"));
        waitingList.add(new Patient(1,"Ciku"));
        waitingList.add(new Patient(2,"Maka"));
        waitingList.add(new Patient(1,"Dosa"));
        printRemainingPatient();

        // treat a patient
        treatPatient();

        // remaining patient after treatment
        printRemainingPatient();

    }
}
