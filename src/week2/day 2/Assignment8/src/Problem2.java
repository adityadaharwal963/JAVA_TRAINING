import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    /*
    Online Exam Waiting System (Queue)
    Objective
    Implement a waiting queue for students.
    Tasks
    1. 2. 3. Add 5 students to a queue.
    Remove 2 students after they are served.
    Display the next student in line.
    Concepts Used
    1. , LinkedList
     */

    final static private Queue<String> waitingQueue = new LinkedList<String>();

    public static void main(String[] args) {
        // Add 5 students to a queue.
        waitingQueue.offer("Student1");
        waitingQueue.offer("Student2");
        waitingQueue.offer("Student3");
        waitingQueue.offer("Student4");
        waitingQueue.offer("Student5");

        // serve students
        System.out.println("Served Student:");
        System.out.println(waitingQueue.poll());
        System.out.println(waitingQueue.poll());

        // display next student in line
        System.out.println("Display Next in Queue:");
        System.out.println(waitingQueue.peek());
    }
}

