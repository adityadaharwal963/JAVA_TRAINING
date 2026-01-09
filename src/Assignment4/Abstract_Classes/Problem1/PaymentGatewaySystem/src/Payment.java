import java.util.ArrayList;

public abstract class Payment {
    //static Array to track transaction , +ve means deposit , -ve means debit
    static ArrayList<Double> transactions = new ArrayList<>();
    abstract void processPayment(String sendId, String receiverId,double amount);

    // Print Transaction Summary
    final void printSummary(){
        double netTotalAmount = 0;
        double totalAmount = 0;
        System.out.println("Transactions:");
        // for each transaction
        for(double trans : transactions){
            if(trans>0){
                System.out.println("Credit +"+trans);
            }else if(trans<0){
                System.out.println("Debit "+ trans);
            }
            netTotalAmount += trans;
            totalAmount += Math.abs(trans);
        }
        System.out.println("Net Total: "+netTotalAmount);
        System.out.println("Total Transactions Value:"+ totalAmount);

    }

    final void printReceipt(double amount){

        System.out.println("Transaction receipt:");
        if(amount>0){
            System.out.println("Credited Your Account by "+ amount);
        }else {
            System.out.println("Debited Your Account by "+ amount);
        }
    }
}
