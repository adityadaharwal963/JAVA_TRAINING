import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class ReverseFirstKElements {

    static void reverseFirstK(Queue<Integer> queue, int k) {

        if (queue == null || k <= 0 || k > queue.size()) {
            return;
        }

        Stack<Integer> stack = new Stack<>();

        // Push first K elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Enqueue stack elements back to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        //  Move remaining elements to back
        int remaining = queue.size() - k;
        for (int i = 0; i < remaining; i++) {
            queue.add(queue.poll());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        int k = 3;
        reverseFirstK(queue, k);

        System.out.println(queue);
    }
}
