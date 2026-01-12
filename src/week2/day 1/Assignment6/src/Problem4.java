import java.util.ArrayList;
import java.util.Scanner;

public class Problem4 {
    /*
    4. Array Element Fetcher
        Write a program to retrieve an element at a specific index from an array. If the user
        enters an index out of bounds, handle the ArrayIndexOutOfBoundsException and
        prompt the user to re-enter a valid index.
     */
    public  static void fetchArrayElement(int[] array){
        Scanner sc = new Scanner(System.in);
        System.out.println("Pls enter index of array element to fetch :");
        int index = sc.nextInt();
        try{
            System.out.println("element" + array[index]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index, pls enter valid index");
            Problem4.fetchArrayElement(array);
        }catch (Exception e){
            System.out.println("Unhandled error occurred:"+e.getMessage());
        }
    }
}
