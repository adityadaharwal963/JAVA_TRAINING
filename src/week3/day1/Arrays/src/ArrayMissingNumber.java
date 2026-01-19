public class ArrayMissingNumber {

    // Complexity
    // Time O(n)
    // Space O(1)
    public  static  int findMissingNumber(int n , int[] arr){
        int sum = 0;
        for(int num : arr){
            sum+=num;
        }
        return (n*(n+1)/2)-sum;

    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7,6};
        int missingNumber = findMissingNumber(arr.length+1,arr);
        System.out.println(missingNumber);
    }
}
