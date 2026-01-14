import java.util.PriorityQueue;
import java.util.Comparator;

public class problem5 {
    /*
     Hospital Token System (PriorityQueue)
        Objective
        Treat emergency patients first.
        Tasks
        1.  Add normal and emergency patients.
        2. Use PriorityQueue to give emergency higher priority.
        3. Display treatment order.
        Concepts Used
        Queue, PriorityQueue, Comparator
     */
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>(
                new Comparator<Patient>() {
                    @Override
                    public int compare(Patient p1, Patient p2) {
                        // Emergency patients first
                        if (p1.isEmergency && !p2.isEmergency)
                            return -1;
                        if (!p1.isEmergency && p2.isEmergency)
                            return 1;

                        // If same priority, earlier token first
                        return Integer.compare(p1.token, p2.token);
                    }
                }
        );

        // Adding patients
        queue.add(new Patient("Ehkasnk", false, 1));
        queue.add(new Patient("Aditya", true, 2));
        queue.add(new Patient("Ariyaan", false, 3));
        queue.add(new Patient("Pande", true, 4));

        // Display treatment order
        System.out.println("Treatment Order:");
        while (!queue.isEmpty()) {
            Patient p = queue.poll();
            System.out.println(p.name +
                    (p.isEmergency ? " (Emergency)" : " (Normal)"));
        }
    }

}

class Patient {
    String name;
    boolean isEmergency;
    int token;

    public Patient(String name, boolean isEmergency, int token) {
        this.name = name;
        this.isEmergency = isEmergency;
        this.token = token;
    }
}
