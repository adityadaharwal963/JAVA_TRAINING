import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem4 {
    /*
    Frequency Counter Using HashMap
    Problem Statement:
    Given a string, find the frequency of each character and print them in alphabetical order.
    Input:
    programming
    Output:
    a=1
    g=2
    m=2
    p=1
    r=2
     */
    static TreeMap<Character,Integer> count = new TreeMap<>();

    static void countCharFrequency(String string){
        char[] chars = string.toCharArray();

        for(char c: chars){
            if(count.containsKey(c)){
                count.put(c,count.get(c)+1);
            }else{
                count.put(c,1);
            }
        }

        for(Map.Entry<Character,Integer> freq:count.entrySet()){
            System.out.println(freq.getKey()+ " -> "+freq.getValue());
        }
    }

    public static void main(String[] args) {
        String string = "programming";
        countCharFrequency(string);
    }
}
