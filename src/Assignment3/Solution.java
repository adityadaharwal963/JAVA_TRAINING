package Assignment3;

import java.util.Scanner;
import java.util.ArrayList;
public class Solution {

    // problem 1, count odd ,evens in n numbers
   public static void countOddEvenElement(){
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

    // Function for Problem 2
    public static void printFactorialOfNum(int n){
        //Constraint
        if(n>20){
            System.out.println("Invalid Input");
        }else {
            long factorial = 1;
            if(n==0 || n==1){
                System.out.println("Factorial of "+n+" is "+factorial);
            }
            int j = 1;
            while(j<=n){
                factorial*=j;
                j++;
            }
            System.out.println("Factorial of "+n+" is "+factorial);
        }
    }

    // Function for Problem 3
    static void sumOfDigitsUntilSingleDigit(int num){
        int n = num;
        int sum = 0;

        while(n > 0 || sum > 9){
            if(n==0){
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        System.out.println("The sum of digits until single digit of number "+num+" is: "+sum);
    }

    // Function for Problem 4
    static void primeNumberInRange(int a, int b){
        ArrayList<Integer> primes = new ArrayList<>();
        int idx = -1;
        for(int i = a; i<=b; i++){
            primes.add(i);
            idx++;
            for(int j = 2; j<i/2; j++){
                if(i % j == 0) {
                    primes.remove(idx);
                    idx--;
                    break;
                }
            }
        }
        for(int i : primes){
            System.out.print(i+" ");
        }
    }

    // Function for Problem 5
    static void salaryProcessingSystem(int n, ArrayList<Integer> salaries){
        int total = 0;
        for(int i:salaries) total += i;
        System.out.println("Total Salary: "+ total);
        int avg = total / n;
        System.out.println("Average Salary: "+ avg);
        int count = 0;
        for(int i : salaries) if(i > avg) count++;
        System.out.println("No. of Employees earning more than Average: " + count);
    }

    // Function for Problem 6
    public static void printPattern(int n)
    {
        int i, j;

        // print row
        for (i = 0; i < n; i++) {
            //print spaces
            for (j = n - i; j > 1; j--) {
                System.out.print(" ");
            }
            // print stars
            for (j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    // Function for Problem 7
    static void bankingTransactionAnalyzer(int n, ArrayList<Integer> transactions){
        int deposits = 0;
        int withdrawals = 0;
        int finalBalance = 0;
        for(int transaction : transactions){
            if(transaction < 0){
                withdrawals += transaction;
            }
            else {
                deposits += transaction;
            }
            finalBalance += transaction;
        }

        System.out.println("Deposits: "+ deposits + " Withdrawals: " + withdrawals + " Final Balance: " + finalBalance);

    }

    // Function for Problem 8
    // print fibonacciSeries while fibonacci number is less than n
    public static void fibonacciSeries(int n){
       if(n==0){
           System.out.println(0);
       }else{//n==1
           System.out.println("0 1");
       }
       if(n>1){
           int i = 2;
           int t = 1 ;//(i-1)+(i-2); for 2
           while (t<=n){
               System.out.print(" "+ t);
               i++;
               t = (i-1)+(i-2);
           }// print series while fib no. less than or equal n
       }
   }

    // Function for Problem 9
    static void examResultAnalyzer(int n, ArrayList<Integer> marks){
        int highestMark = Integer.MIN_VALUE;
        int lowestMark = Integer.MAX_VALUE;
        int passedStudents = 0;
        for(int mark : marks){
            if(mark > highestMark) highestMark = mark;
            if(lowestMark > mark) lowestMark = mark;
            if(mark >= 40) passedStudents++;
        }
        System.out.println("Highest Mark: "+highestMark+" Lowest Mark: " + lowestMark + " No. of Students Passed: " + passedStudents);
    }

    // print indices of stock below Problem 10
    public static void getIndicOfStockBelow(){
        Scanner sc = new Scanner(System.in);
        //number of input
        int n = sc.nextInt();
        //temp var
        int temp;
        for(int i = 0;i<n;i++){
            temp = sc.nextInt();
            if(temp<10){
                //print Indices
                System.out.print(i+" ");
            }
        }
        sc.close();
    }




    // print indices of stock below 10
    public static void test_p10(){
        Scanner sc = new Scanner(System.in);
        //number of input
        int n = sc.nextInt();
        //temp var
        int temp;
        for(int i = 0;i<n;i++){
            temp = sc.nextInt();
            if(temp<10){
                System.out.print(i+" ");
            }
        }
        sc.close();
    }

}

