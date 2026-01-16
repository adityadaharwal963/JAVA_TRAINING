import java.util.HashMap;
import java.util.Map;

public class Problem7 {
    /*
    Bank Account Directory
    Concept: HashMap
    Scenario
    A bank stores account number and customer name.
    Task
    1. Add at least 5 accounts.
    2. Search customer name using account number.
    3. Delete an account.
    4. Display updated directory. 
     */

    // Hashmap to store Bank Account accountNumber as key and Account as  value
    final static HashMap<Integer,Account> accountDirectory = new HashMap<>();

    static void displayAccountDirectory(){
        for(Map.Entry<Integer, Account> account :accountDirectory.entrySet()){
            System.out.println(account.getValue());
        }
    }

    static void searchCustomerName(Integer accountNumber){
        if(accountDirectory.containsKey(accountNumber)){
            System.out.println(accountDirectory.get(accountNumber).getName());
        }else {
            System.out.println("Account Number not Found");
        }
    }

    static void deleteAccount(Integer accountNumber){
        if(accountDirectory.containsKey(accountNumber)){
            System.out.println("Deleted Account Holder:");
            System.out.println(accountDirectory.get(accountNumber).getName());
            accountDirectory.remove(accountNumber);
        }else {
            System.out.println("Account Number not Found");
        }
    }

    public static void main(String[] args) {
        // generate account
        Account account1 = new Account(100,"Ram");
        Account account2 = new Account(101,"Raa");
        Account account3 = new Account(102,"Rag");
        Account account4 = new Account(103,"Rom");
        Account account5 = new Account(104,"Som");

        // add account to bank system
        accountDirectory.put(account1.getAccountNumber(),account1);
        accountDirectory.put(account2.getAccountNumber(),account2);
        accountDirectory.put(account3.getAccountNumber(),account3);
        accountDirectory.put(account4.getAccountNumber(),account4);
        accountDirectory.put(account5.getAccountNumber(),account5);

        // display Accounts
        displayAccountDirectory();

        searchCustomerName(104);

        deleteAccount(104);
        // display Accounts
        displayAccountDirectory();
    }

}

class Account {
    private Integer accountNumber;
    private String name;

    public Account(Integer accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }
}