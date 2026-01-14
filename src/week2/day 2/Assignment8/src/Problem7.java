import java.util.LinkedList;
import java.util.Queue;

public class Problem7 {
    /*
    Queue Operations Simulator
    Problem
    Simulate queue operations.
    Tasks
    1. Enqueue 5 numbers.
    2. Dequeue 2 numbers.
    3. Display remaining elements.
    4. Show front element using peek().
     */

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        // 1. Enqueue 5 numbers
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        // 2. Dequeue 2 numbers
        queue.poll();
        queue.poll();

        // 3. Display remaining elements
        System.out.println("Remaining elements in the queue:");
        for (int num : queue) {
            System.out.println(num);
        }

        // 4. Show front element using peek()
        System.out.println("Front element: " + queue.peek());
    }
}
