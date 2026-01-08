package Assignment1;

import  java.lang.Boolean;
import java.util.Scanner;

//class handles loan applications , Problem 1
public class Problem1Loan {
    //Check Advance Loan Eligibility of customer based on parameters
    //Returns True is eligible
    public Boolean checkEligibility(int age , int salary, int creditScore, String employmentType){
        if(age>=21 && age<=60 && salary>=30000 && creditScore>=650){
            if(employmentType.equals("Salaried")){
                return true;
            }else if(employmentType.equals("SelfEmployed") && creditScore>=700){
                return true;
            }
        }
        return false;
    }
    // test program for single input
    public void test(){
        Scanner sc = new Scanner(System.in);
        // Take User input
        System.out.println("Enter Customer Details");
        System.out.println("Age:");
        int age = sc.nextInt();
        System.out.println("Salary:");
        int salary = sc.nextInt();
        System.out.println("Credit Score:");
        int creditScore = sc.nextInt();
        System.out.println("Employment Type, Choices (Salaried,SelfEmployed)");
        String employmentType = sc.next();

        boolean eligible = this.checkEligibility(age,salary,creditScore,employmentType);
        if(eligible){
            System.out.println("Congrats Your are Eligibility");
        }else{
            System.out.println("Sorry are not Eligibility");
        }
        sc.close();
    }

    // test program for multiple input
    public void testMultiple(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases");
        int testcases = sc.nextInt();
        sc.close();
        for(int i = 0;i<testcases;i++){
            this.test();
        }
    }
}
