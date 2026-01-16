import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem10 {
/*
    9. Java Queue – Ticket Counter Simulation
    Problem Statement:
    People are standing in a queue to buy tickets.
    Each person takes 1 second.
    Given N people, simulate the queue and print the order in which people are served.
    Hint:
    Use Queue<String> with LinkedList.
     */

    public static Character findFirstNonRepeated(String str) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> repeated = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!repeated.contains(ch)) {
                if (!queue.contains(ch)) {
                    queue.offer(ch); // Add to queue
                } else {
                    queue.remove(ch); // Remove from queue
                    repeated.add(ch); // Mark as repeated
                }
            }
        }

        return queue.isEmpty() ? null : queue.peek();
    }

    public static void main(String[] args) {
        String input = "swiss";
        Character result = findFirstNonRepeated(input);

        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
