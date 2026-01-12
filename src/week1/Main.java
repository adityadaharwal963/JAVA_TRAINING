import Assignment1.Problem6ATM;

public class Main {


    // calculate time required for execution
    static void measureExecutionTime(String taskName,Runnable task ) {
        try{
            long startTime = System.currentTimeMillis();
            task.run();
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;
            System.out.println("Task run:" + taskName + " execution time:"+ timeTaken);
        }catch (Exception e){
            System.out.println("Error "+ e.getMessage());
        }
    }

    //Logic for problem statement
    public void  solution() {
        System.out.println("Hello, World!");
        int loop = 1000000;
        while (loop>0){
            loop--;
        }
    }

    public static void main(String[] args) {
        try{
            Problem6ATM p = new Problem6ATM();
            measureExecutionTime("Assignment 2 Problem 6",p::test);
        }catch (Exception e){
            System.out.println("Error "+ e.getMessage());
        }

    }
}

