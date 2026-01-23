import java.util.HashMap;

public class SubarrayWithEqualNumber01 {
        public int findMaxLength(int[] nums) {
            HashMap<Integer,Integer> prefix = new HashMap<>();
            int longest = 0;
            int total_sum = 0;

            prefix.put(total_sum, -1);
            for(int i=0;i<nums.length;i++){
                int curr_longest = 0;
                total_sum += nums[i]==0?-1:1;
                if(prefix.containsKey(total_sum)){
                    Integer j = prefix.get(total_sum);
                    curr_longest = Math.max(curr_longest, i - j);
                }else{
                    prefix.put(total_sum, i);
                }

                prefix.put(total_sum,Math.min(prefix.get(total_sum),i));
                longest = Math.max(curr_longest,longest);
            }
            return longest;
        }
    }

