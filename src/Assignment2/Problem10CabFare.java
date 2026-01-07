package Assignment2;

import java.util.Scanner;

public class Problem10CabFare {
    /*
    Problem 10: Cab Fare Estimation System
    Problem Description
    Calculate cab fare using distance, cab type, and night charges.
    Fare Rules
    Cab Type Rate/km
    Mini
    10
    Sedan
    15
    SUV
    20
    Night charge (22:00-05:00) → +25%
    Input Format distance cabType
    lisNight (true/false)
     */

    public static  void getCabFare(String cabType, int distance,boolean isNight){
        double fareAmount = switch (cabType) {
            case "Mini" -> distance * 10;
            case "Sedan" -> distance * 15;
            case "SUV" -> distance * 20;
            default -> 0;
        };

        if(isNight){
            fareAmount += fareAmount*0.25;
        }

        System.out.println("You Cab Fare: "+fareAmount+" Rs");
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Ride Details:");
        System.out.println("Cab Type (Mini/Sedan/SUV):");
        String cabType = sc.next();
        System.out.println("Night time (11:00 - 5:00)? yes/no :");
        boolean isNight = sc.next().equalsIgnoreCase("yes");
        System.out.println("Distance:");
        int distance = sc.nextInt();
        getCabFare(cabType, distance,isNight);
        sc.close();
    }
}

