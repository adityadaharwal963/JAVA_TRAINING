class Queue<T> {
    private T[] queue;
    private int front, rear, size;

    // Constructor
    Queue(int size) {
        this.size = size;
        queue = (T[]) new Object[size]; // Generic array creation
        front = -1;
        rear = -1;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return front == -1;
    }

    // Add element to queue
    void enqueue(T value) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1) { // First insertion
            front = 0;
        }

        queue[++rear] = value;
        System.out.println("Enqueued: " + value);
    }

    // Remove element from queue
    T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return null;
        }

        T value = queue[front];

        if (front == rear) { // Queue becomes empty
            front = -1;
            rear = -1;
        } else {
            front++;
        }

        System.out.println("Dequeued: " + value);
        return value;
    }

    // Get front element
    T peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }
        return queue[front];
    }
}
