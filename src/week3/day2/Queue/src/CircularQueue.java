class CircularQueue<T> {
    private T[] queue;
    private int front, rear, size;

    CircularQueue(int size) {
        this.size = size;
        queue = (T[]) new Object[size];
        front = -1;
        rear = -1;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return front == -1;
    }

    // Check if queue is full
    boolean isFull() {
        return (front == (rear + 1) % size);
    }

    // Insert element
    void enqueue(T value) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        queue[rear] = value;
        System.out.println("Enqueued: " + value);
    }

    // Remove element
    T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return null;
        }

        T value = queue[front];

        if (front == rear) { // Only one element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }

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
