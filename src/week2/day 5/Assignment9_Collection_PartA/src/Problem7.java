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
    Java PriorityQueue – Hospital Emergency System
    Problem Statement:
    Patients arrive with a priority number (lower number = higher priority).
    Process patients in the correct order using PriorityQueue.
    Input:
    4
    John 3
    Mary 1
    Alex 2
    Sam 1
    Output:
    Mary
    Sam
    Alex
    John
     */

    static PriorityQueue<Patient> waitingList = new PriorityQueue<>();

    public static void main(String[] args) {
        // add people to queue
        waitingList.add(new Patient(3,"John"));
        waitingList.add(new Patient(1,"Mary"));
        waitingList.add(new Patient(2,"Alex"));
        waitingList.add(new Patient(1,"Sam"));

        // print serving order
        System.out.println("Serving Order");
        while (!waitingList.isEmpty()){
            System.out.println(waitingList.poll());
        }
    }
}
