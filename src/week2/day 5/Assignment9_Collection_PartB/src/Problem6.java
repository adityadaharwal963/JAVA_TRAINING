import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem6 {
    /*
    Call Center Queue Management
    Scenario:
    A customer support center handles calls in order.
    Requirements:
     Add incoming callers
     Serve callers in FIFO order
     Display waiting callers
    Hint:
    Use Queue<String> with LinkedList
     */

    static Queue<String> waitingList = new LinkedList<>();

    static void handleCall(){
        if(!waitingList.isEmpty()){
            System.out.print("Talking to : ");
            System.out.println(waitingList.poll());
        }else {
            System.out.println("No More calls");
        }
    }

    static void printRemainingCall(){
        System.out.println("Remaining Calls");
        ArrayList<String> remaining = new ArrayList<>(waitingList);
        for(String c : remaining){
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        // adding calls in waiting list
        waitingList.offer("Customer1");
        waitingList.offer("Customer2");
        waitingList.offer("Customer3");
        waitingList.offer("Customer4");
        waitingList.offer("Customer5");

        //  Display waiting callers
        printRemainingCall();
        // handle call in FIFO order
        handleCall();
        handleCall();
        // Display waiting callers
        printRemainingCall();
    }

}
