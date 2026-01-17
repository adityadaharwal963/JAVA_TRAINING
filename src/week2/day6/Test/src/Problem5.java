import java.util.Scanner;

public class Problem5 {
    static String reverseSentence(String sentence){
        String[] words = sentence.trim().split(" ");

        StringBuilder sb = new StringBuilder("");
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]+" ");
        }
        // String Builder is mutable and good for single thread application
        System.out.println("Reverse: "+sb.toString().trim());
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        reverseSentence(sentence);
    }
}
