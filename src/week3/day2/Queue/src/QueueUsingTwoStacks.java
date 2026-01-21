import java.util.Stack;

class QueueUsingTwoStacks<T> {

    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();

    // Enqueue operation
    void enqueue(T value) {
        s1.push(value);
        System.out.println("Enqueued: " + value);
    }

    // Dequeue operation
    T dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue Underflow");
            return null;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    // Check if queue is empty
    boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
