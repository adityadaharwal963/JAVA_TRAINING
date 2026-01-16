import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem1 {
    // Count Unique Numbers in list using set

    static void printUniqueNumber(List<Integer> numbers){
        HashSet<Integer> set = new HashSet<>();
        set.addAll(numbers);
        System.out.println("Unique Numbers: "+ set.size());
    }

    public static void main(String[] args) {
        // declare a list
        List<Integer> list = new ArrayList<>();
        //take the input
        int[] arr = {5,3,5,2,8,3,9,2,1,5};
        //add elements to list
        for(Integer i: arr){
            list.add(i);
        }
        printUniqueNumber(list);
    }
}
