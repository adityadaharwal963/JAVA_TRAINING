package PartA;

public class TaskScheduler {
    public static void main(String[] args) {

        Runnable task1 = () -> {
            System.out.println("Task 1 running in " + Thread.currentThread().getName());
        };

        Runnable task2 = () -> {
            System.out.println("Task 2 running in " + Thread.currentThread().getName());
        };

        Runnable task3 = () -> {
            System.out.println("Task 3 running in " + Thread.currentThread().getName());
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();
    }
}
