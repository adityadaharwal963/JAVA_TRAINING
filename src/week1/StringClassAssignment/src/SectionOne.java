import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SectionOne {

    /*
            1. String Operations
            ○ Write a program to take a sentence as input and:
                ■ Find its length.
                ■ Extract a substring from index 5 to 10.
                ■ Convert the entire string to uppercase and lowercase.
        2. Palindrome Check
            ○ Create a program to check whether a given string is a palindrome.
        3. Anagram Checker
            ○ Write a program to check if two given strings are anagrams of each other.
        4. Character Frequency
            ○ Create a program to count the occurrence of each character in a string.
        5. Word Reverse
            ○ Write a program to reverse the words in a given sentence (e.g., "Hello World" → "olleH dlroW").
     */

    static void problem_1(){
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        System.out.println("Length: "+sentence.length());
        System.out.println("Substring: "+sentence.substring(5,10));
        System.out.println("Uppercase: "+sentence.toUpperCase());
        System.out.println("Lowercase: "+sentence.toLowerCase());
        sc.close();
    }
    static void problem_2(){
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char[] chars = string.toCharArray();
        boolean isPalindrome = true;
        int len = chars.length;
        for(int i=0;i<len/2;i++){
            if(chars[i] != chars[len -1 -i]){
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome){
            System.out.println("Palindrome");
        }else {
            System.out.println("Not Palindrome");
        }
        sc.close();
    }
    static  void problem_3(){
        Scanner sc = new Scanner(System.in);
        char[] str1 = sc.next().toLowerCase().toCharArray();
        char[] str2 = sc.next().toLowerCase().toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i:str1){
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }

        boolean isAnagram = true;

        for(char i : str2){
            if(!(map.containsKey(i) && map.get(i)>0)){
                isAnagram = false;
                break;
            }else {
                map.put(i,map.get(i)-1);
            }
        }
        if(isAnagram){
            System.out.println("Anagram");
        }else {
            System.out.println("Not Anagram");
        }
        sc.close();
    }
    static void problem_4(){
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i:str){
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i,1);
            }
        }
        for(Map.Entry<Character,Integer> p: map.entrySet()){
            System.out.println("Char:"+ p.getKey()+"Frequency"+p.getValue());
        }
        sc.close();
    }
    static void problem_5(){
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] words = sentence.split(" ");
        for(String word: words){
            char[] tempArray = word.toCharArray();
            for(int i = tempArray.length-1;i>=0;i--){
                System.out.print(tempArray[i]);
            }
            System.out.println(" ");
        }
        sc.close();
    }

    public static void main(String[] args) {
        problem_3();
    }
}
