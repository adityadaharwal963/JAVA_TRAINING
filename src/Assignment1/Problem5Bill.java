package Assignment1;

import java.util.Scanner;

public class Problem5Bill {

    // calculate bill using slabs + peak hour surcharge
    // parameters hours , peakHour
    // return bill amount
    Double calculateElectricBill(int hours,Boolean peakHour){
        double amount = 0;
        // billing rate logic
        // 2rs charge for 100 hrs , 4rs next hrs
        if(hours>=100){
            //100*2 = 200 basic charge
            amount = 200 + (hours-100)*4;
        }else {
            amount = hours*2;
        }
        // add peak hour charge
        if(peakHour){
            amount += amount * 0.1;
        }
        return amount;
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        //Take Inputs
        System.out.println("Enter Following Details To Generate Bill :");
        System.out.println("Number of Hours used");
        int hours = sc.nextInt();
        System.out.println("Peak hours: (Yes/No)");
        String choice = sc.next();
        boolean peak = choice.equalsIgnoreCase("Yes");
        // Bill amount
        double amount = calculateElectricBill(hours,peak);
        System.out.println("Please Pay Bill:"+amount+" Rupees");
//
    }
}
