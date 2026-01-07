package Assignment2;

import java.util.Scanner;

public class Problem8Insurance {
    /*
    Problem 8: Insurance Policy Eligibility
    Problem Dascription
    Policy eligibility based on age, medical history, and soking status.
    Rules
    • Аде 18-60
    No critical illness
    Smoken → premium increases by 20%
    Input Format
    isSomker
    hasCriticalIllness true/false
    BasePremium
    Output Format
•   Print Not Eligible or final premium amount
     */

    public static void  checkInsurance(int age,double basePremium, boolean isSmoker, boolean hasCriticalIllness){
        if(age<=60 && age>=18 && !hasCriticalIllness){
            if(isSmoker){
                basePremium += basePremium*0.2;
            }
            System.out.println("Your Premium is:"+basePremium);
        }
        System.out.println("Not Eligible");
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Insurance Details:");
        System.out.println("Age:");
        int age = sc.nextInt();
        System.out.println("Current Basic Premium");
        double basicPremium = sc.nextDouble();
        System.out.println("Do you Smoke? yes/no :");
        boolean isSmoker = sc.next().equalsIgnoreCase("yes");
        System.out.println("Do you have critical illness ? yes/no :");
        boolean hasIllness = sc.next().equalsIgnoreCase("yes");
        checkInsurance(age,basicPremium,isSmoker,hasIllness);
        sc.close();
    }
}
