import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Problem8 {
    /*
    Word Occurrence Analyzer
    Scenario:
    A text analysis tool counts word frequency.
    Requirements:
     Count occurrences of each word
     Display words in alphabetical order
     Identify most frequent word
    Hint:
    Use TreeMap<String, Integer>
     */

    static TreeMap<String,Integer> wordCount = new TreeMap<>();

    static void countCharFrequency(String string){
        String[] words = string.trim().split(" ");

        for(String word: words){
            if(wordCount.containsKey(word)){
                wordCount.put(word,wordCount.get(word)+1);
            }else{
                wordCount.put(word,1);
            }
        }

        for(Map.Entry<String,Integer> freq:wordCount.entrySet()){
            System.out.println(freq.getKey()+ " -> "+freq.getValue());
        }

        Map.Entry<String, Integer> mostFrequent = Collections.max(
                wordCount.entrySet(),
                Map.Entry.comparingByValue()
        );

        System.out.println("Most Frequent Word: "+mostFrequent.getKey() +" -> "+mostFrequent.getValue());
    }

    public static void main(String[] args) {
        String string = "Java is programming language . Java is fun ";
        countCharFrequency(string);
    }
}
