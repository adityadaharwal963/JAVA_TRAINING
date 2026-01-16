import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Problem2 {
    /*
    2. Remove Duplicates Using Set
    Problem Statement:
    Given a list of integers, remove duplicate elements while maintaining the original insertion
    order.
    Constraint:
    Do not use manual loops to check duplicates.
    Hint:
    Use LinkedHashSet.
     */

    static LinkedHashSet<Integer> temp = new LinkedHashSet<>();

    static ArrayList<Integer> removeDuplicate(ArrayList<Integer> array){
        temp.clear(); // clear temp buffer
        temp.addAll(array); // create set
        return new ArrayList<>(temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(3);
        System.out.println(arrayList);
        System.out.println( removeDuplicate(arrayList));

    }
}
