package Assignment4;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;
import  java.util.Map;
public class Solution {

    // problem 1
    public static void printMinMaxValueOfArray(int[] array){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i: array){
            if (i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }
        System.out.println("Max:"+max+" Min:"+min);
    }



    //problem2
    public  static  int[] leftRotateArray(int[] array,int d){
        while(d>0) {
            int lastElement = array[array.length - 1];

            for (int i = 0; i < array.length - 1; i++) {
                array[i + 1] = array[i];
            }
            array[0] = lastElement;
            d--;
        }
        return array;
    }

    //problem 3
    public static void countEvenOddElements(){
        Scanner sc = new Scanner(System.in);
        //number of input
        int n = sc.nextInt();
        //temp var
        int temp;
        //count
        int even = 0;
        int odd = 0;
        for(int i = 0;i<n;i++){
            temp = sc.nextInt();
            if(temp%2==0){
                even++;
            }else {
                odd++;
            }
        }
        System.out.println("Odd:"+odd+" Even:"+even);
        sc.close();
    }

    //problem 4
    public static void secondLargest(int[] array){
        if(array.length == 1){
            System.out.println("Only one element");
        }else {
            int largest = Integer.MIN_VALUE;
            int secondLargest = Integer.MIN_VALUE;

            for(int i : array){
                if(i>largest){
                    secondLargest = largest;
                    largest = i;
                }
            }

            System.out.println("Second Largest element is :"+secondLargest);
        }
    }

    // problem 5
    public static int[] sumRowsOfMatrix(int[][] matrix){
        int rows = matrix.length;
        int[] rowSum = new int[rows]; // all initialize to zero
        for(int i=0;i<rows;i++){
            int col = matrix[i].length;
            for(int j =0 ;j<col;j++){
                rowSum[i]+= matrix[i][j];
            }
        }
        // return array having sum of rows
        return rowSum;
    }


    //problem 6
    public  static void isPalindrome(String string){
        int len = string.length();
        char[] array = string.toCharArray();
        boolean isPalindrome = true;
        for(int i=0;i<len/2;i++){
            if(array[i] !=  array[len - 1 - i]){
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome){
            System.out.println("String is palindrome");
        }else {
            System.out.println("String is not palindrome");
        }
    }

    // problem 7
    public static void countVowels(String string){
        char[] chars = string.toCharArray();
        int count = 0;
        Set<Character> vowels = new HashSet<>(
                Arrays.asList('a','e','i','o','u')
        );

        for(char c: chars){
            if(vowels.contains(c)){
                count++;
            }
        }
        System.out.println("Vowel in string: "+count);
    }

    //problem 8
    public  static void  countCharFrequency(String string){
        HashMap<Character,Integer> frequency = new HashMap<>();
        char[] charArray = string.toCharArray();

        for(char c: charArray){
            if(frequency.containsKey(c)){
                frequency.put(c,1);
            }else {
                frequency.put(c,frequency.get(c)+1);
            }
        }
        for(Map.Entry<Character,Integer> pair : frequency.entrySet()){
            System.out.println("Char: "+pair.getKey()+" Frequency: "+ pair.getValue());
        }
    }

    // problem 9
    public static void displayLongestWord(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sentence in one Line:");
        String sentence = sc.nextLine();
        // Split by white space in sentence to words
        String[] words = sentence.split(" ");
        String longestWord = "";

        for(String word: words){
            if(word.length()>longestWord.length()){
                longestWord = word;
            }
        }

        System.out.println("Longest Word: "+longestWord);
    }

    // problem 10
    public static void countNamesStartsWithChar(String[] names, Character character, int N ){
        int count = 0;
        for(String name : names){
            if(name.startsWith(character.toString())){
                count++;
            }
        }
        System.out.println("Count: "+ count);
    }

    public static void main(String[] args) {

    }
}
