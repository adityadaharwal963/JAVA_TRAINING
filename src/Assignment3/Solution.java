package Assignment3;

import java.util.Scanner;

public class Solution {

    // count odd ,evens in n numbers
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


    // print indices of stock below 10
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

    public static void main(String[] args) {

    }
}

