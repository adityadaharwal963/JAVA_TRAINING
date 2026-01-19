import java.util.Arrays;

public class MergeSortedArray {

    // Complexity
    // Time O(m+n)
    // Space O(m+n)
    public static int[] mergeSortedArray(int[] arr1,int[] arr2){

        int i = 0;
        int j =0;
        int[] mergedArray = new int[arr1.length+arr2.length];
        int k =0;
        while(i< arr1.length && j< arr2.length){
            if(arr1[i]<=arr2[j]){ // ascending order , small first
                mergedArray[k]= arr1[i];
                i++;
            }else {
                mergedArray[k] = arr2[j];
                j++;
            }
            k++;
        }
        //push remaining
        while(i< arr1.length){
            mergedArray[k]= arr1[i];
            i++;
            k++;
        }
        while(j< arr2.length){
            mergedArray[k]= arr2[j];
            j++;
            k++;
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arr1= {1,3,5,7};
        int[] arr2 = {2,4,6,8};
        int[] sortedArray = mergeSortedArray(arr1,arr2);
        System.out.println(Arrays.toString(sortedArray));
    }
}
