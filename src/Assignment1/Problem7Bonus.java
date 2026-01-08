package Assignment2;

import java.util.Scanner;

public class Problem7Bonus {
//    bonus on experience and
Double calculateBonus(int experience,int salary , int rating){
    double amount = 0;
    if(experience>=10){
        if(rating>=4){
            amount = salary*0.2;//20%
        }else {
            amount = salary*0.10;//10%
        }
    }else if(experience>=5){
        if(rating>=4){
            amount = salary*0.15;//15%
        }else {
            amount = salary*0.07;//7%
        }
    }else {
        if(rating>=4){
            amount = salary*0.10;//10%
        }else {
            amount = salary*0.05;//5%
        }
    }

    return amount;
}

    public void test(){
        Scanner sc = new Scanner(System.in);
        //Take Inputs
        System.out.println("Enter Following Details To Get Bonus Amount :");
        System.out.println("Experience in years:");
        int experience = sc.nextInt();
        System.out.println("Salary:");
        int salary = sc.nextInt();
        System.out.println("Rating");
        int rating= sc.nextInt();

        // Bonus amount
        double amount = calculateBonus(experience,salary,rating);
        System.out.println("Your Bonus:"+amount+" Rupees");
//
    }
}

/*
Policy eligibility
age, medical history, smoking status
 */

/*
Exam results , input section A, B,C
each section <=40
total>=120
any section < 40 -> fail
 */

/*
Cab Fare
distance (km) , cab type, night charges
mini 10 per km

 */