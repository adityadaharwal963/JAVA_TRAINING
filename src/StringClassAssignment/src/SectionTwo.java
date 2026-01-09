import java.sql.Time;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SectionTwo {
    /*
    StringBuffer Class
    6. Mutable String Operations
        ○ Use StringBuffer to perform the following on a string:
            ■ Append " Java Programming" to the string.
            ■ Insert "is fun " at the 6th position.
            ■ Replace "Programming" with "Language".
            ■ Reverse the entire string.
    7. Performance Comparison
        ○ Compare the performance of String concatenation and StringBuffer when appending 1000 characters in a loop.
    8. Vowel Remover
        ○ Write a program that removes all vowels from a given string using
            StringBuffer.
     */

    static void problem_6(){
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        sb.append("Java Programming");
        System.out.println(sb);
        sb.insert(5,"is fun ");
        System.out.println(sb);
        sb.replace(sb.length()-11,sb.length(),"Language");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sc.close();
    }
    static void problem_7(){
        String a = "a";
        String temp = "a";
        StringBuffer tem  = new StringBuffer(temp);
        //String
        long starttime  = System.currentTimeMillis();
            for(int i=0;i<1000;i++){
                temp = temp.concat(a);
            }
        long endtime  = System.currentTimeMillis();
        long timetaken = (endtime-starttime);
        System.out.println("Time By String: " + timetaken+"ms");
        starttime  = System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            tem.append(a);
        }
        endtime  = System.currentTimeMillis();
        timetaken = (endtime-starttime);
        System.out.println("Time By StringBuffer: " + timetaken+"ms");

    }

    static void problem_8(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuffer sb = new StringBuffer(s);
        HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a','e','i','o','u','A','E','I','U','O')
        );
        int deleteCount = 0;
        for(int i= 0;i<sb.length();i++){
            if(vowels.contains(sb.charAt(i))){
                sb.deleteCharAt(i-deleteCount);
                deleteCount++;
            }
        }
        System.out.println(sb);
        sc.close();
    }

    public static void main(String[] args) {
        problem_7();
    }
}
