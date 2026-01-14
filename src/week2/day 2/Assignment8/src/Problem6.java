import java.util.*;

public class Problem6 {
    /*
    Remove Duplicates from List
    Problem
    Given a list of integers, remove duplicates and display them in sorted order.
    Tasks
    1. Store numbers in a List.
    2. Convert to TreeSet.
    3. Print the result.
     */

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Store numbers in a List
        for(int i=0;i<10;i++){
            list.add(i);
        }
        for(int i=10;i>0;i--){
            list.add(i);
        }
        System.out.println(list.getClass());
        System.out.println(list);
        // Convert to TreeSet
        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(list);

        // Print the result
        System.out.println(set.getClass());
        System.out.println(set);
    }
}
