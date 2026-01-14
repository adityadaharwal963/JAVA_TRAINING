import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    /*
    Email Subscription System (Set)
    Objective
    Ensure only unique email IDs are stored.
    Tasks
    1. Accept 10 email IDs.
    2. Store them in a HashSet.
    3. Display total unique subscribers.
    Concepts Used
    HashSet, Set
     */

    static void displayUniqueEmails(ArrayList<String> emails){
        Set<String> uniqueEmail = new HashSet<>();
        // store emails in hashset
        uniqueEmail.addAll(emails);
        // display unique subscribes
        System.out.println("Unique Emails:");
        for(String email : uniqueEmail){
            System.out.println(email);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> emails = new ArrayList<>();

        //Accepted 10 email IDs.
        emails.add("abc@gmail.com");
        emails.add("bbc@gmail.com");
        emails.add("cbc@gmail.com");
        emails.add("abc@gmail.com");
        emails.add("bbc@gmail.com");
        emails.add("cbc@gmail.com");
        emails.add("abc@gmail.com");
        emails.add("bbc@gmail.com");
        emails.add("cbc@gmail.com");
        emails.add("yoyo@gmail.com");

        // find unique emails , also display them
        displayUniqueEmails(emails);
    }
}
