package Assignment1;

import java.util.Scanner;

public class Problem9Result {
    /*
    Problem Description
    Determine exam result based on section wise cutoffs
    Rules
    • Each section ≥ 40
    • Total≥ 120
    • Any section < 40 → Fail
    Input Format

    section A, B, C

    Output Format
    Print Pass or fail
     */

    public  static void determineResult(int[] marks){
        boolean passEachSection = true;
        int totalMarks = 0;
        // check marks in section
        for(int mark: marks){
            if(mark<40){
                passEachSection = false;
            }
            totalMarks+= mark;
        }
        if(passEachSection && totalMarks>=120){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Marks  of sections: ");
        System.out.println("Section A:");
        int sectionA = sc.nextInt();
        System.out.println("Section B:");
        int sectionB = sc.nextInt();
        System.out.println("Section C:");
        int sectionC = sc.nextInt();
        int[] array = {sectionA,sectionB,sectionC};
        determineResult(array);
    }
}
