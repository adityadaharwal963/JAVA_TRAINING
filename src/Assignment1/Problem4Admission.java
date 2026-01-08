package Assignment2;

import java.util.Scanner;

public class Problem4Admission {

    public Boolean checkAdmissionEligibility(int marks, int entrance, String category){
        if(category.equalsIgnoreCase("General") && marks >70 && entrance>80){
            return true;
        }else if(category.equalsIgnoreCase("OBC") && marks >65 && entrance>75){
            return true;
        }else if((category.equalsIgnoreCase("SC") || category.equalsIgnoreCase("ST")) && marks >60 && entrance>70){
            return true;
        }
        return false;
    }
    public void test(){
        Scanner sc = new Scanner(System.in);
        //Take Inputs
        System.out.println("Enter Following Details:");
        System.out.println("Marks:");
        int marks = sc.nextInt();
        System.out.println("Entrance marks:");
        int entrance = sc.nextInt();
        System.out.println("Category (General, OBC, SC, ST)");
        String category = sc.next();
        // check
        Boolean eligible = checkAdmissionEligibility(marks,entrance,category);
        if(eligible){
            System.out.println("Admission Granted");
        }else{
            System.out.println("Admission Denied");
        }
    }
}
