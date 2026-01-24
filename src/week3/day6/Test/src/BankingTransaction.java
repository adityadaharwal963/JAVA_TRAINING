import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
class Account {
    private int balance;
    private int accountNumber;
    private TreeMap<Integer,Transaction> transaction = new TreeMap<>();
    public Account(int balance,int accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    private void setBalance(int amount) {
        this.balance += amount;
    }

    void addTransaction(Transaction transaction) {
        if(this.transaction.containsKey(transaction.transactionId)) {
            System.out.println("Transaction already exists");
        } else if (isTransactionValid(transaction.amount)) {
            System.out.println("Transaction not valid");
        }else {
            this.transaction.put(transaction.transactionId, transaction);
            this.setBalance(this.balance + transaction.amount);
        }
    }

    boolean isTransactionValid(int amount) {

        if(this.balance - amount < 0) {
            return false;
        }
        return true;
    }

    void displayTransactions() {
        int total_amount = 0;

        for(Transaction transaction : this.transaction.values()){
            total_amount += transaction.amount;
            if(balance - transaction.amount >= 0) {

            }
        }
    }

    void simulateMissingTransaction(int transactionId) {
        this.transaction.remove(transactionId);
    }
}
class Transaction implements Comparable<Transaction>{
    int transactionId;
    int accountNumber;
    String type;//[DEBIT/CREDIT]
    int amount;
    int timestamp;

    @Override
    public int compareTo(Transaction o) {
        return this.timestamp - o.timestamp;
    }
}


public class BankingTransaction {
    TreeMap<Integer, Transaction> transactions = new TreeMap<>();
    ArrayList<Transaction> transactionsList = new ArrayList<>();
    static boolean isValidTransaction(BankingTransaction transaction) {
//        if transaction.
    }


    public static void main() {

        Scanner input = new Scanner(System.in);
    }
}

