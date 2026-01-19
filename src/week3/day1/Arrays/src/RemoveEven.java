import java.util.Arrays;

public class RemoveEven {
    // time O(n)
    // space O(1)
    public static int[] removeEvenInteger(int[] array){
        int nonEvenIndex = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0){
                int temp = array[nonEvenIndex];
                array[nonEvenIndex] = array[i];
                array[i] = temp;
                nonEvenIndex++;
            }
        }
        // print non even integer
        for(int i=0;i<nonEvenIndex;i++){
            System.out.print(array[i]+" ");
        }
        return array;
    }
    public static void main(String[] args) {
        int[] array = {3,2,4,7,10,6,5};
        array = removeEvenInteger(array);
//        System.out.println(Arrays.toString(array));
    }
}
