import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // Complexity
    // Time O(n)
    // Space O(n)

    public static int[] productArray(int[] arr){
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];
        if(arr.length==1){
            return arr;
        }
        prefix[0] = 1;

        for(int i=1;i<arr.length;i++){
            prefix[i] = prefix[i-1]*arr[i-1];
        }

        suffix[arr.length-1] = 1;

        for(int i=arr.length-2; i>=0;i--){
            suffix[i] = suffix[i+1]*arr[i+1];
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = prefix[i] * suffix[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        array = productArray(array);
        System.out.println(Arrays.toString(array));
    }
}
