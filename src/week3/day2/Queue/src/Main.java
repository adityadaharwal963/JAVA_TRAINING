public class Main {
    public static void main(String[] args) {

        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue()); // Underflow
    }
}
