import java.util.Arrays;

public class RemoveDuplicateInSortedArray {
    // time complexity O(n)
    // space O(1)

    public static int[] removeDuplicate(int[] array){
        int num = -1;
        int nonRepeatingIndex = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=num){
                num = array[i];
                System.out.println(num);
                array[nonRepeatingIndex] = num;
                nonRepeatingIndex++;
            }
        }
        // replaced rest with -1
        for(int i=nonRepeatingIndex;i<array.length;i++){
            array[i]=-1;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {0,1,1,1,1,2,3,4};
        array = removeDuplicate(array);
        System.out.println(Arrays.toString(array));
    }
}
