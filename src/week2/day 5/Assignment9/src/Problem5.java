import java.util.LinkedHashMap;
import java.util.Map;

public class Problem5 {
    /*
    5. Frequency Counter
    Concept: HashMap + Set
    Problem
    Given a sentence, count how many times each word appears.
    Input
    java is easy and java is powerful
    Output
    java → 2
    is → 2
    easy → 1
    and → 1
    powerful → 1
     */


    final private  static LinkedHashMap<String,Integer> wordFrequency = new LinkedHashMap<>();
    static void displayWordFrequency(){
        for(Map.Entry<String,Integer> log: wordFrequency.entrySet()){
            System.out.println(log.getKey()+" -> "+log.getValue());
        }
    }

    static void countWord(String sentence){

        String[] words = sentence.trim().split(" ");
        for(String word:words){
            if(wordFrequency.containsKey(word)){
                wordFrequency.put(word,wordFrequency.get(word)+1);
            }else {
                wordFrequency.put(word,1);
            }
        }
    }

    public static void main(String[] args) {
        String sentence = "java is easy and java is powerful";
        countWord(sentence);
        displayWordFrequency();
    }
}
