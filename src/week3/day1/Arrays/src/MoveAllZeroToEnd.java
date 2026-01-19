import java.util.Arrays;

public class MoveAllZeroToEnd {
    // Complexity
    // Time O(n)
    // Space O(1)
    public static int[] move0toEnd(int[] arr){
        int nonZerOIndex = 0;
        if(arr.length == 1){
            return arr;
        }

        // swap the last non-zero index
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                // swap non zero index
                int temp = arr[i];
                arr[i] = 0;
                arr[nonZerOIndex] = temp;
                nonZerOIndex++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,0,5,0,0,6,7,8};
        arr = move0toEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
}
