package Assignment1;


import java.util.Scanner;

// Class handle tax Calculation, problem 2
public class Problem2TaxCalculator {
    // return tax slab percentage based gender and income
    public double calculateTaxSab(int income, String gender){
        double amount = 0;
        if(income<=500000){
            amount = income * 0.05;
        } else if (income<=1000000) {
            amount = income * 0.1;
        }
        //10000 exemption for females
        if(gender.equals("Female")){
            amount = Math.max(0,amount-10000);
        }
        return amount;
    }
    // test program for single input
    public void test(){
        Scanner sc = new Scanner(System.in);
        // Take User input
        System.out.println("Enter  Details");
        System.out.println("Income:");
        int income = sc.nextInt();
        System.out.println("Gender: (Male,Female)");
        String gender = sc.next();
        double taxSab = calculateTaxSab(income,gender);
        System.out.println("Your Tax Amount is "+taxSab+"%");
        sc.close();
    }

    // test program for multiple input
    public void testMultiple(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testcases = sc.nextInt();
        sc.close();
        for(int i = 0;i<testcases;i++){
            this.test();
        }
    }
}
