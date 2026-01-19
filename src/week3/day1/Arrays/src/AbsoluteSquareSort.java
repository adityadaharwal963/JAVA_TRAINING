import java.util.Arrays;
import java.util.Map;

public class AbsoluteSquareSort {
    public static int[] mergeSortedSquareArray(int[] arr){
        int pivot = 0;
        // find pivot index where
        for(int i=0;i<arr.length ;i++){
            if(arr[i]>-1){
                pivot = i;
                break;
            }
        }
        int i=pivot;
        int j =pivot-1;
        int[] mergedArray = new int[arr.length];

        int k =0;
        while(i<arr.length && j>=0){
            // compare abs value
            if(Math.abs(arr[i])<=Math.abs(arr[j])){ // ascending order , small first
                mergedArray[k]= arr[i]*arr[i];
                i++;
            }else {
                mergedArray[k] = arr[j]*arr[j];
                j--;
            }
            k++;
        }
        //push remaining
        while(i< arr.length){
            mergedArray[k]= arr[i]*arr[i];
            i++;
            k++;
        }
        while(j>=0){
            mergedArray[k]= arr[j]*arr[j];
            j--;
            k++;
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arr1= {-8,-4,0,1,3,5,7};
        int[] sortedArray = mergeSortedSquareArray(arr1);
        System.out.println(Arrays.toString(sortedArray));
    }
}
