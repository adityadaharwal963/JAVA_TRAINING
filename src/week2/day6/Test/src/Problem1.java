import java.util.Scanner;

public class Problem1 {

    static void findSecond(int[] arr) {

        if (arr.length == 2) {
            System.out.println("Second Largest: " + Math.min(arr[0], arr[1]));
        } else {
            int largest = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= largest) {
                    second = largest;
                    largest = arr[i];
                }
            }
            System.out.println("Second Largest: " + second);
        }
    }
    static void problem1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        findSecond(arr);

    }

    public static void main(String[] args) {
    problem1();
    }
}
