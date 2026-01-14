import java.util.*;

public class Problem8 {
    /*
    First Non-Repeated Character Finder
    Problem
    Find the first non-repeating character in a string.
    Tasks
    1.  Add characters to a Queue.
    2. Track repeats using a Set.
    3. Display the first unique character.
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

