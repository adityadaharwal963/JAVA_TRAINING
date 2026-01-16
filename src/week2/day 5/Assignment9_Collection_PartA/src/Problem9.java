import java.util.LinkedList;
import java.util.Queue;

public class Problem9 {
    /*
    Java Queue – Ticket Counter Simulation
    Problem Statement:
    People are standing in a queue to buy tickets.
    Each person takes 1 second.
    Given N people, simulate the queue and print the order in which people are served.
    Hint:
    Use Queue<String> with LinkedList.
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
