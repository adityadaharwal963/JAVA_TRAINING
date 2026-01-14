import java.util.LinkedList;
import java.util.Queue;

public class Problem10 {
    /*
    Assignment 10: Ticket Counter Simulation
    Problem
    Simulate people standing in a ticket queue.
    Tasks
    1. 2. Add customers to a queue.
    Serve them one by one.
    3. Display service order.
     */
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        // Add customers to the queue
        queue.add("Customer 1");
        queue.add("Customer 2");
        queue.add("Customer 3");
        queue.add("Customer 4");

        // Serve customers one by one
        System.out.println("Service Order:");
        while (!queue.isEmpty()) {
            String customer = queue.poll();
            System.out.println(customer);
        }
    }
}
