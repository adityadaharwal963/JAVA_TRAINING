import java.util.Arrays;

public class TripleSum {

    // Complexity
    // Time O(n^2)
    // Space O(1)
    public static void distinctTripleSum(int[] array, int target){

        Arrays.sort(array); // n log(n)
        for(int i=0;i< array.length-2;i++){ // n + 2
            int j = i+1;
            int k = array.length -1;
            while (j<array.length-1 && j<k){ // n
                int sum = array[i]+ array[j]+array[k];
                if(target == sum){
                    System.out.println("{"+array[i]+ " "+array[j]+" "+array[k]+"}");
                    k--;
                }else if(sum>target) {
                    k--;
                }else {
                    j++;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr1= {2,3,1,4,7,6,8,3,0};
        distinctTripleSum(arr1,6);
    }
}
