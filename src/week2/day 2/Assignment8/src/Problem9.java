import java.util.HashSet;
import java.util.Scanner;

public class Problem9 {
    /*
    Unique Word Counter
    Problem
    Count unique words in a sentence.
    Tasks
    1. Read a sentence from user.
    2. Split into words.
    3. Store in HashSet.
    4. Print count of unique words.
     */


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

        String[] words = sentence.toLowerCase().split(" ");

        HashSet<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println("Number of unique words: " + uniqueWords.size());

        scanner.close();
    }
}
