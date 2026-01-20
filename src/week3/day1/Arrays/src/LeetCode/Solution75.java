package LeetCode;

public class Solution75 {
    public void sortColors(int[] nums) {
        // insertion sort is in-place sort
        for(int i=0;i<nums.length-1;i++){
            int j = i+1;
            int key = nums[j];
            while(j>0 && nums[j-1]>key){
                nums[j]= nums[j-1];
                j--;
            }
            nums[j] = key;
        }

    }
}
