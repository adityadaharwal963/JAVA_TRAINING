package LeetCode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution75 solution = new Solution75();
        int[] test1 = {2,0,2,1,1,0};
        solution.sortColors(test1);
        System.out.println(Arrays.toString(test1));
        int[] test2 = {2,0,1};
        solution.sortColors(test2);
        System.out.println(Arrays.toString(test2));
    }
}
